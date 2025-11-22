package src.ui.tecnologia;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.util.*;
import src.entidades.*;


public class DialogRelatorioTecnologia extends JDialog{
    private CatalogoParticipantes catalogoParticipantes;

    public DialogRelatorioTecnologia(CatalogoParticipantes catalogoParticipantes){
        this.catalogoParticipantes = catalogoParticipantes;
    }
    
    public List<String> mostrarRelatorio(){
        for(Participante p : catalogoParticipantes.getParticipantes()){
            if(p instanceof Fornecedor){
                Fornecedor f = (Fornecedor) p;
                return f.mostrarRelatorioDeTecnologias();
            }
        }
        return null;
    }
}
