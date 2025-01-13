package com.pokeinv.View.shared.Composants;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.net.URL;

public class Notification {
    private static JFrame mainFrame;

    public static void setMainFrame(JFrame frame) {
        mainFrame = frame;
    }

    public static void showNotification(String message) {
        if (mainFrame != null) {
            NotificationDialog notification = new NotificationDialog(message);
            notification.setLocationRelativeToOwner(mainFrame);
            notification.setVisible(true);
            notification.playSound();
        }
    }

    private static JPanel getContainer(String message) {
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
//        container.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        container.setBorder(new MatteBorder(1, 1, 1, 1, new Color(60, 60, 75, 100)));
        container.setOpaque(true);
        container.setBackground(new Color(28, 28, 51));
        container.setForeground(Color.WHITE);
        URL imageUrl = Notification.class.getResource("/icons/bell.png");
        String htmlMessage = """
                             <html>
                                <body style='width: 300 px;padding:0;margin:0'>
                                <h2 style="padding:5px;margin:0;border-bottom:1px solid #3C3C4B1D">
                                <img src="%s" width="20" height="20" style='margin-right:40px;'>&nbsp;&nbsp;&nbsp;Notification</h2>
                                                  
                                <div style="padding:15px">
                                    <p>%s</p>
                                </div>
                                </body>
                             </html>
                             """.formatted(imageUrl, message);

        JLabel label = new JLabel(htmlMessage, SwingConstants.LEFT);
        label.setForeground(Color.WHITE);
        container.add(label);
        return container;
    }

    private static class NotificationDialog extends JDialog {

        public NotificationDialog(String message) {
            super(mainFrame, "Notification", true);
            setModalityType(ModalityType.MODELESS);
            setLayout(new BorderLayout());
            setMaximumSize(new Dimension(300, getHeight()));
            setMinimumSize(new Dimension(300, 80));
            setUndecorated(true);
            setBackground(new Color(0, 0, 0, 0));

            JPanel container = getContainer(message);
            add(container, BorderLayout.CENTER);

            Timer timer = new Timer(30000, e -> dispose());
            timer.setRepeats(false);
            timer.start();

            pack();
        }

        public void setLocationRelativeToOwner(Frame owner) {
            int ownerX = owner.getX();
            int ownerY = owner.getY();
            int ownerWidth = owner.getWidth();
            int ownerHeight = owner.getHeight();

            int notificationWidth = getWidth();
            int notificationHeight = getHeight();

            int notificationX = ownerX + ownerWidth - notificationWidth - 10;
            int notificationY = ownerY + ownerHeight - notificationHeight - 10;

            setLocation(notificationX, notificationY);
        }

        private void playSound() {
            try {

                try {

                    URL url = getClass().getResource("/notifications/notification_info.wav");
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    clip.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
