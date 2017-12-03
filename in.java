public final class StartFormat {
    private StartFormat() {}
    /**
     * Main method.
     * @param args console arguments
     * @throws Exception exception
     */
    public static void main(final String[] args) throws Exception {
        IFormatter formatter = new Formatter(new LexerFactory());

        try (
                FileReader reader = new FileReader(args[0]);
                FileWriter writer = new FileWriter(args[1])
        ) {
            formatter.format(reader, writer);
        }
    }
}