public final class StartFormat {
    private StartFormat() {
    }

    public static void main(final String[] args) throws Exception {
        IFormatter formatter = new Formatter(new LexerFactory());
    }
}