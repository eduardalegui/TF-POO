package src.ui.venda;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.util.*;
import src.entidades.*;


public class DialogRelatorioVenda extends JDialog{
    private CatalogoParticipantes catalogoParticipantes;
    public DialogRelatorioVenda(CatalogoParticipantes catalogoParticipantes){

    }
    
    public List<String> mostrarRelatorio(){
        for(Participante p : catalogoParticipantes.getParticipantes()){
            if(p instanceof Comprador){
                Comprador c = (Comprador) p;
                return c.mostrarRelatorioDeVendas();
            }
        }
        return null;
    }
}
