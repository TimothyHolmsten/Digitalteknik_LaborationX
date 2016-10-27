package logicgate;

import java.util.ArrayList;

/**
 * Created by timothy on 28/09/16.
 */
abstract class Gate implements OutputCalculator {
    private ArrayList<OutputCalculator> inputs;

    public Gate() {
        inputs = new ArrayList<>();
    }

    public int numberOfInputs() {
        return inputs.size();
    }

    public OutputCalculator getInput(int index) {
        return inputs.get(index);
    }

    public void printTruthTable() throws IllegalAccessException, InstantiationException {
        Gate tempGate = this.getClass().newInstance();
        // Cases => 2^numberOfInputs();
        System.out.println("Truthtable, " + this.getClass().getSimpleName());
        for (int i = 0; i < Math.pow(2, numberOfInputs()); i++) {
            for (int j = numberOfInputs() - 1; j >= 0; j--) {
                int logicInput = i / (int) Math.pow(2, j) % 2; // Taken from StackOverflow
                System.out.print(logicInput + "   ");
                if (logicInput == 1)
                    tempGate.addInput(new Generator(true));
                else
                    tempGate.addInput(new Generator(false));
            }
            System.out.println("|  " + tempGate.outputToInt());

            tempGate.clearInputs();
        }

    }

    public void connectTo(Gate g) {
        g.addInput(this);
    }

    public void addInput(OutputCalculator o) {
        inputs.add(o);
    }

    public void removeInput(int index) {
        inputs.remove(index);
    }

    private void clearInputs() {
        inputs.clear();
    }

    private int outputToInt() {
        try {
            if (getOutput())
                return 1;
        } catch (AllInputsNotDefinedException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
