package logicgate;

/**
 * Created by timothy on 2016-10-04.
 */
public class NotGate extends Gate {
    @Override
    public boolean getOutput() throws AllInputsNotDefinedException {

        if (numberOfInputs() != 1) throw new AllInputsNotDefinedException("There must be exactly one input");

        return !getInput(0).getOutput();
    }
}
