package model;

import model.interfaces.BlockInterface;

public class DecisionBlock extends Block implements BlockInterface {

    @Override
    public void setContent(String content) {
        // TODO: sprawdzanie czy tekst zwraca
    }

    @Override
    public String toCode() {
        return "";
    }

    public void setPosition(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
