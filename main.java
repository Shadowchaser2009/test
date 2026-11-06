public class main {
    public static void main (String[] args) {
        Stundenplan meinPlan = new Stundenplan();

        meinPlan.ausgabe();
        System.out.println();

        meinPlan.suche("Mathematik");
        System.out.println();

        meinPlan.suche("Philosophie");
    }

    private static class Stundenplan {
        private String[][] plan;

        public Stundenplan() {
            plan = new String[][] {
                { "Mathematik", "Deutsch", "Englisch", "Mathematik", "Sport" },
                { "Deutsch", "Mathematik", "Sport", "Geschichte", "Englisch" },
                { "Biologie", "Chemie", "Physik", "Deutsch", "Informatik" },
                { "Kunst", "Musik", "Geschichte", "Informatik", "Biologie" }
            };
        }

        public void ausgabe() {
            String[] tage = { "Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag" };
            System.out.println("=== STUNDENPLAN ===");

            System.out.printf("%-12s", "Stunde");
            for (String tag : tage) {
                System.out.printf("%-12s", tag);
            }
            System.out.println();
            for (int i = 0; i < tage.length + 1; i++) {
                System.out.print("------------");
            }
            System.out.println();

            for (int i = 0; i < plan.length; i++) {
                System.out.printf("%-12s", i + 1);
                for (int j = 0; j < plan[i].length; j++) {
                    System.out.printf("%-12s", plan[i][j]);
                }
                System.out.println();
            }
        }

        public void suche(String pFach) {
            boolean gefunden = false;
            String[] tage = { "Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag" };

            System.out.println("Suche nach Fach: \"" + pFach + "\"");

            for (int i = 0; i < plan.length; i++) {
                for (int j = 0; j < plan[i].length; j++) {
                    if (plan[i][j].equals(pFach)) {
                        System.out.println("-> Gefunden in der " + (i + 1) + ". Stunde am " + tage[j] + ".");
                        gefunden = true;
                    }
                }
            }

            if (!gefunden) {
                System.out.println("-> Das Fach \"" + pFach + "\" ist nicht im Stundenplan enthalten.");
            }
        }
    }
}
