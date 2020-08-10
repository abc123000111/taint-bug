import edu.columbia.cs.psl.phosphor.runtime.MultiTainter;

public class PhosphorExamples
{
    public static Integer multi3(int x) {
        Integer k = new Integer("3");
        Integer w = new Integer(x);
        return w * k;
    }

    public static String strHanlder(String demo) {
        return "Hello ," + demo;
    }

    public static void testExample1() {
        int x = 0;
        x = MultiTainter.taintedInt(x, 10000);
        x = MultiTainter.taintedInt(x, "I am x sink.");
        Integer y = multi3(x);
        System.out.println("y: " + MultiTainter.getTaint(y).toString());
        assert ("Taint [Labels = [[I am x sink.]]".equalsIgnoreCase(MultiTainter.getTaint(y).toString()));
    }

    public static void testExample2() {
        String demo = "Phosphor World";
        char[] demoChars = MultiTainter.taintedCharArray(demo.toCharArray(), "I am x sink.");
        String result = strHanlder(demoChars.toString());
        System.out.println("result taint: " + MultiTainter.getTaint(result).toString());
        assert ("Taint [Labels = [[I am x sink.]]".equalsIgnoreCase(MultiTainter.getTaint(result).toString()));
    }

    // Sourced from the original Phosphor code
    public static void main(String[] args) {
        testExample1();
        testExample2();
    }
}