import java.util.*;

/**
 * AdvancedCalculator
 *
 * Fixes applied vs. the original:
 *  - Removed javax.script/Nashorn dependency (getEngineByName("JavaScript") returns
 *    null on Java 15+, causing a guaranteed NullPointerException on every eval;
 *    it was also a code-injection risk since raw user input was fed to a JS engine).
 *  - Replaced it with a small self-contained recursive-descent expression parser.
 *  - Fixed PrintHelp/printHelp naming mismatch (would not compile).
 *  - Implemented all previously-missing methods: printWelcome, printHelp,
 *    printHistory, printVariables, handleMemory, handleAssignment,
 *    format, and degree/radian-aware trig handling.
 *  - '^' is now a real right-associative operator (handles expressions like
 *    (2+3)^2 or x^2), not a regex that only matched bare numeric literals.
 *  - Factorial (n!) is a real postfix operator in the parser.
 */
public class advancedCalculator1 {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Deque<String> history = new ArrayDeque<>();
    private static final Map<String, Double> variables = new HashMap<>();

    private static double memory = 0.0;
    private static double lastResult = 0.0;
    private static boolean degreesMode = true;   // true = degrees, false = radians
    private static boolean programmerMode = false;

    public static void main(String[] args) {
        printWelcome();

        while (true) {
            System.out.print(programmerMode ? "PROG> " : (degreesMode ? "DEG> " : "RAD> "));
            if (!scanner.hasNextLine()) break;
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) continue;

            String lower = input.toLowerCase();

            // ===== Commands =====
            if (lower.equals("exit") || lower.equals("quit") || lower.equals("q")) {
                System.out.println("Goodbye!");
                break;
            }
            if (lower.equals("help") || lower.equals("?")) {
                printHelp();
                continue;
            }
            if (lower.equals("clear") || lower.equals("cls")) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                continue;
            }
            if (lower.equals("history") || lower.equals("hist")) {
                printHistory();
                continue;
            }
            if (lower.equals("deg")) {
                degreesMode = true;
                System.out.println("Angle mode set to Degrees");
                continue;
            }
            if (lower.equals("rad")) {
                degreesMode = false;
                System.out.println("Angle mode set to Radians");
                continue;
            }
            if (lower.equals("prog") || lower.equals("programmer")) {
                programmerMode = !programmerMode;
                System.out.println("Programmer mode: " + (programmerMode ? "ON" : "OFF"));
                continue;
            }
            if (lower.equals("vars") || lower.equals("variables")) {
                printVariables();
                continue;
            }
            if (lower.equals("mc")) {
                memory = 0;
                System.out.println("Memory cleared");
                continue;
            }
            if (lower.equals("mr")) {
                System.out.println("Memory = " + format(memory));
                lastResult = memory;
                continue;
            }
            if (lower.startsWith("m+") || lower.startsWith("m-") || lower.startsWith("ms")) {
                handleMemory(input);
                continue;
            }

            // ===== Variable assignment: x = 5  or  x = 2*pi =====
            if (input.matches("^[a-zA-Z_][a-zA-Z0-9_]*\\s*=.*")) {
                handleAssignment(input);
                continue;
            }

            // ===== Evaluate expression =====
            try {
                double result = new Parser(input).parseAll();
                lastResult = result;
                history.addFirst(input + " = " + format(result));
                if (history.size() > 50) history.removeLast();

                System.out.println("= " + format(result));

                if (programmerMode) {
                    long val = Math.round(result);
                    System.out.println("  BIN: " + Long.toBinaryString(val));
                    System.out.println("  OCT: " + Long.toOctalString(val));
                    System.out.println("  HEX: " + Long.toHexString(val).toUpperCase());
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }

    // ==================== Commands ====================

    private static void printWelcome() {
        System.out.println("========================================");
        System.out.println(" Advanced Calculator");
        System.out.println(" Type 'help' for commands, 'exit' to quit");
        System.out.println("========================================");
    }

    private static void printHelp() {
        System.out.println("Commands:");
        System.out.println("  deg, rad          switch angle mode");
        System.out.println("  prog              toggle programmer mode (shows BIN/OCT/HEX)");
        System.out.println("  vars              list stored variables");
        System.out.println("  history / hist    show calculation history");
        System.out.println("  mc / mr           memory clear / memory recall");
        System.out.println("  m+ [n]            add n (or last result) to memory");
        System.out.println("  m- [n]            subtract n (or last result) from memory");
        System.out.println("  ms [n]            store n (or last result) into memory");
        System.out.println("  clear / cls       clear the screen");
        System.out.println("  x = <expr>        assign a variable");
        System.out.println("  exit / quit / q   exit the program");
        System.out.println();
        System.out.println("Supported: + - * / % ^  ! (factorial)  ( )");
        System.out.println("Functions: sin cos tan asin acos atan sinh cosh tanh");
        System.out.println("           ln log log10 sqrt cbrt abs floor ceil round exp");
        System.out.println("Constants: pi, e, ans (last result)");
    }

    private static void printHistory() {
        if (history.isEmpty()) {
            System.out.println("(no history yet)");
            return;
        }
        int i = history.size();
        for (String h : history) {
            System.out.println("  " + i + ": " + h);
            i--;
        }
    }

    private static void printVariables() {
        if (variables.isEmpty()) {
            System.out.println("(no variables set)");
            return;
        }
        for (Map.Entry<String, Double> e : variables.entrySet()) {
            System.out.println("  " + e.getKey() + " = " + format(e.getValue()));
        }
    }

    private static void handleMemory(String input) {
        String op = input.substring(0, 2);      // "m+", "m-", or "ms"
        String rest = input.substring(2).trim();
        double amount;
        try {
            amount = rest.isEmpty() ? lastResult : new Parser(rest).parseAll();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }
        switch (op) {
            case "m+":
                memory += amount;
                break;
            case "m-":
                memory -= amount;
                break;
            case "ms":
                memory = amount;
                break;
        }
        System.out.println("Memory = " + format(memory));
    }

    private static void handleAssignment(String input) {
        int eq = input.indexOf('=');
        String name = input.substring(0, eq).trim();
        String exprPart = input.substring(eq + 1).trim();

        if (name.equals("pi") || name.equals("e") || name.equals("ans")) {
            System.out.println("Error: '" + name + "' is a reserved constant");
            return;
        }
        try {
            double value = new Parser(exprPart).parseAll();
            variables.put(name, value);
            lastResult = value;
            System.out.println(name + " = " + format(value));
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static String format(double d) {
        if (Double.isNaN(d)) return "NaN";
        if (Double.isInfinite(d)) return d > 0 ? "Infinity" : "-Infinity";
        if (d == Math.rint(d) && !Double.isInfinite(d) && Math.abs(d) < 1e15) {
            return String.valueOf((long) d);
        }
        String s = String.format("%.10f", d);
        // trim trailing zeros, keep at least one decimal digit
        s = s.replaceAll("0+$", "");
        s = s.replaceAll("\\.$", ".0");
        return s;
    }

    // ==================== Expression Parser ====================
    // Recursive-descent parser/evaluator. Replaces the previous
    // ScriptEngine("JavaScript") approach, which was both broken
    // (Nashorn removed from modern JDKs) and unsafe (arbitrary
    // script execution on user input).
    //
    // Grammar:
    //   expr    := term (('+' | '-') term)*
    //   term    := unary (('*' | '/' | '%') unary)*
    //   unary   := ('-' | '+')? power
    //   power   := postfix ('^' unary)?      // right-associative
    //   postfix := primary ('!')*
    //   primary := NUMBER | IDENT | IDENT '(' args ')' | '(' expr ')'
    //   args    := expr (',' expr)*
    private static class Parser {
        private final String s;
        private int pos = 0;

        Parser(String s) {
            this.s = s;
        }

        double parseAll() {
            double v = parseExpr();
            skipWs();
            if (pos != s.length()) {
                throw new RuntimeException("Unexpected character '" + s.charAt(pos) + "'");
            }
            return v;
        }

        private void skipWs() {
            while (pos < s.length() && Character.isWhitespace(s.charAt(pos))) pos++;
        }

        private char peek() {
            skipWs();
            return pos < s.length() ? s.charAt(pos) : '\0';
        }

        private boolean consume(char c) {
            skipWs();
            if (pos < s.length() && s.charAt(pos) == c) {
                pos++;
                return true;
            }
            return false;
        }

        private double parseExpr() {
            double v = parseTerm();
            while (true) {
                char c = peek();
                if (c == '+') {
                    pos++;
                    v += parseTerm();
                } else if (c == '-') {
                    pos++;
                    v -= parseTerm();
                } else {
                    break;
                }
            }
            return v;
        }

        private double parseTerm() {
            double v = parseUnary();
            while (true) {
                char c = peek();
                if (c == '*') {
                    pos++;
                    v *= parseUnary();
                } else if (c == '/') {
                    pos++;
                    double d = parseUnary();
                    if (d == 0) throw new RuntimeException("Division by zero");
                    v /= d;
                } else if (c == '%') {
                    pos++;
                    v %= parseUnary();
                } else {
                    break;
                }
            }
            return v;
        }

        private double parseUnary() {
            char c = peek();
            if (c == '-') {
                pos++;
                return -parseUnary();
            }
            if (c == '+') {
                pos++;
                return parseUnary();
            }
            return parsePower();
        }

        private double parsePower() {
            double base = parsePostfix();
            if (peek() == '^') {
                pos++;
                double exp = parseUnary(); // right-associative
                return Math.pow(base, exp);
            }
            return base;
        }

        private double parsePostfix() {
            double v = parsePrimary();
            while (peek() == '!') {
                pos++;
                v = factorial(v);
            }
            return v;
        }

        private double parsePrimary() {
            skipWs();
            if (pos >= s.length()) {
                throw new RuntimeException("Unexpected end of expression");
            }
            char c = s.charAt(pos);

            if (c == '(') {
                pos++;
                double v = parseExpr();
                if (!consume(')')) throw new RuntimeException("Missing closing ')'");
                return v;
            }

            if (Character.isDigit(c) || c == '.') {
                int start = pos;
                while (pos < s.length() && (Character.isDigit(s.charAt(pos)) || s.charAt(pos) == '.')) pos++;
                return Double.parseDouble(s.substring(start, pos));
            }

            if (Character.isLetter(c) || c == '_') {
                int start = pos;
                while (pos < s.length() && (Character.isLetterOrDigit(s.charAt(pos)) || s.charAt(pos) == '_')) pos++;
                String name = s.substring(start, pos);

                if (peek() == '(') {
                    pos++;
                    List<Double> args = new ArrayList<>();
                    if (peek() != ')') {
                        args.add(parseExpr());
                        while (consume(',')) {
                            args.add(parseExpr());
                        }
                    }
                    if (!consume(')')) throw new RuntimeException("Missing closing ')' after " + name);
                    return applyFunction(name, args);
                }

                return resolveIdentifier(name);
            }

            throw new RuntimeException("Unexpected character '" + c + "'");
        }

        private double resolveIdentifier(String name) {
            switch (name) {
                case "pi": return Math.PI;
                case "e": return Math.E;
                case "ans": return lastResult;
                default:
                    Double v = variables.get(name);
                    if (v == null) throw new RuntimeException("Unknown variable '" + name + "'");
                    return v;
            }
        }

        private double applyFunction(String name, List<Double> args) {
            double a = args.isEmpty() ? 0 : args.get(0);
            switch (name) {
                case "sin": return Math.sin(toRadiansIfNeeded(a));
                case "cos": return Math.cos(toRadiansIfNeeded(a));
                case "tan": return Math.tan(toRadiansIfNeeded(a));
                case "asin": return fromRadiansIfNeeded(Math.asin(a));
                case "acos": return fromRadiansIfNeeded(Math.acos(a));
                case "atan": return fromRadiansIfNeeded(Math.atan(a));
                case "sinh": return Math.sinh(a);
                case "cosh": return Math.cosh(a);
                case "tanh": return Math.tanh(a);
                case "ln": return Math.log(a);
                case "log": case "log10": return Math.log10(a);
                case "sqrt":
                    if (a < 0) throw new RuntimeException("sqrt of negative number");
                    return Math.sqrt(a);
                case "cbrt": return Math.cbrt(a);
                case "abs": return Math.abs(a);
                case "floor": return Math.floor(a);
                case "ceil": return Math.ceil(a);
                case "round": return Math.round(a);
                case "exp": return Math.exp(a);
                case "pow":
                    if (args.size() < 2) throw new RuntimeException("pow requires 2 arguments");
                    return Math.pow(a, args.get(1));
                default:
                    throw new RuntimeException("Unknown function '" + name + "'");
            }
        }

        private double toRadiansIfNeeded(double v) {
            return degreesMode ? Math.toRadians(v) : v;
        }

        private double fromRadiansIfNeeded(double v) {
            return degreesMode ? Math.toDegrees(v) : v;
        }

        private double factorial(double v) {
            if (v < 0 || v != Math.floor(v)) {
                throw new RuntimeException("Factorial requires a non-negative integer");
            }
            long n = (long) v;
            double result = 1;
            for (long i = 2; i <= n; i++) result *= i;
            return result;
        }
    }
}
    

