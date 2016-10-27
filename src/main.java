import logicgate.*;

/**
 * Created by timothy on 28/09/16.
 */
public class main {
    public static void main(String args[]) {
        AndGate and = new AndGate();
        OrGate or = new OrGate();
        NotGate not = new NotGate();
        XORGate xor = new XORGate();

        Generator gen1 = new Generator(true);
        Generator gen2 = new Generator(false);
        Generator gen3 = new Generator(true);
        Generator gen4 = new Generator(true);

        and.addInput(gen1);
        and.addInput(gen2);
        and.addInput(gen3);

        or.addInput(gen1);
        or.addInput(gen2);
        or.addInput(gen3);
        or.addInput(gen4);

        not.addInput(gen1);

        xor.addInput(gen1);
        xor.addInput(gen2);
        xor.addInput(gen3);
        xor.addInput(gen4);

        //or.connectTo(and);

        try {
            System.out.println(xor.getOutput());
            xor.printTruthTable();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
