package logicgate;

/**
 * Created by timothy on 2016-10-04.
 */
public class XORGate extends Gate {

    @Override
    public boolean getOutput() throws AllInputsNotDefinedException {

        if (numberOfInputs() < 2) throw new AllInputsNotDefinedException("There must be two or more inputs");
        
        int numberOfTrue = 0;
        for (int i = 0; i < numberOfInputs(); i++)
            if (getInput(i).getOutput())
                numberOfTrue++;

        // If odd number then return true
        return numberOfTrue % 2 == 1;
    }
}
