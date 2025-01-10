package com.pokeinv.events;

import java.io.IOException;
import javax.swing.JPanel;
import com.pokeinv.View.inscription.InscriptionView;

public class subscriptionEvent {

    public void subscriptionEvent(JPanel mainFrame) {
        try {
            InscriptionView interfacePrincipaleInscription = new InscriptionView();

            mainFrame.removeAll();
            mainFrame.add(interfacePrincipaleInscription);
            mainFrame.revalidate();
            mainFrame.repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
