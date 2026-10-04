public class Main {
    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("--demo")) {
            runDemo();
        }
    }

    public static void runDemo() {
        int passed = 0;

        Circle t1 = new Circle("C1", 2, new VectorRenderer());
        String t1Result = t1.execute();
        String t1Expected = "VECTOR circle radius=2";
        passed += printTest(
                "T1",
                "Circle + VectorRenderer",
                t1Result,
                t1Expected
        );

        Circle t2 = new Circle("C2", 2, new RasterRenderer());
        String t2Result = t2.execute();
        String t2Expected = "RASTER circle radius=2";
        passed += printTest(
                "T2",
                "Circle + RasterRenderer",
                t2Result,
                t2Expected
        );

        Square t3 = new Square("S1", 3, new VectorRenderer());
        String t3Result = t3.execute();
        String t3Expected = "VECTOR square side=3";
        passed += printTest(
                "T3",
                "Square + VectorRenderer",
                t3Result,
                t3Expected
        );

        Square t4 = new Square("S2", 3, new RasterRenderer());
        String t4Result = t4.execute();
        String t4Expected = "RASTER square side=3";
        passed += printTest(
                "T4",
                "Square + RasterRenderer",
                t4Result,
                t4Expected
        );

        Circle t5 = new Circle("C5", 2, new VectorRenderer());
        Circle original = t5;

        String idBefore = t5.getId();
        int radiusBefore = t5.getRadius();
        String before = t5.execute();

        t5.setImplementation(new RasterRenderer());

        String after = t5.execute();

        boolean sameObject = original == t5;
        boolean stateUnchanged =
                idBefore.equals(t5.getId()) &&
                        radiusBefore == t5.getRadius();

        boolean t5Pass =
                sameObject &&
                        stateUnchanged &&
                        before.equals("VECTOR circle radius=2") &&
                        after.equals("RASTER circle radius=2");

        if (t5Pass) {
            System.out.println(
                    "T5 PASS | Circle + runtime switch | sameObject=" +
                            sameObject +
                            " | stateUnchanged=" +
                            stateUnchanged
            );

            System.out.println(
                    " before=" + before +
                            " | after=" + after
            );

            passed++;
        } else {
            System.out.println(
                    "T5 FAIL | Circle + runtime switch | sameObject=" +
                            sameObject +
                            " | stateUnchanged=" +
                            stateUnchanged
            );

            System.out.println(
                    " before=" + before +
                            " | after=" + after
            );

            System.out.println(
                    " expectedBefore=VECTOR circle radius=2" +
                            " | expectedAfter=RASTER circle radius=2"
            );
        }

        Circle t6 = new Circle("C6", 2, new AsciiRenderer());
        String t6Result = t6.execute();
        String t6Expected = "ASCII circle radius=2";
        passed += printTest(
                "T6",
                "Circle + AsciiRenderer",
                t6Result,
                t6Expected
        );

        Square t7 = new Square("S7", 3, new AsciiRenderer());
        String t7Result = t7.execute();
        String t7Expected = "ASCII square side=3";
        passed += printTest(
                "T7",
                "Square + AsciiRenderer",
                t7Result,
                t7Expected
        );

        System.out.println("SUMMARY: " + passed + "/7 PASS");
    }

    public static int printTest(
            String id,
            String classes,
            String actual,
            String expected
    ) {
        boolean pass = actual.equals(expected);

        if (pass) {
            System.out.println(
                    id + " PASS | " +
                            classes +
                            " | result=" +
                            actual
            );

            return 1;
        }

        System.out.println(
                id + " FAIL | " +
                        classes +
                        " | result=" +
                        actual +
                        " | expected=" +
                        expected
        );

        return 0;
    }
}