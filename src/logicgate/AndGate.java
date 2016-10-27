package logicgate;

/**
 * Created by timothy on 28/09/16.
 */
public class AndGate extends Gate {

    @Override
    public boolean getOutput() throws AllInputsNotDefinedException {

        if (numberOfInputs() < 2) throw new AllInputsNotDefinedException("There must be two or more inputs");

        for (int i = 0; i < numberOfInputs(); i++)
            if (!getInput(i).getOutput())
                return false;
        return true;
    }
}
