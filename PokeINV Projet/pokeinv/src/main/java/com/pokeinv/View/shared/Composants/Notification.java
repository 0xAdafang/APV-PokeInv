package com.pokeinv.View.shared.Composants;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.pokeinv.View.shared.SoundPlayer;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class Notification {
    public static int SUCCESS = 0;
    public static int ERROR = 1;
    public static int INFO = 2;
    private static int type;
    private static JFrame mainFrame;

    public static void setMainFrame(JFrame frame) {
        mainFrame = frame;
    }

    public static void showNotification(String message) {
        if (mainFrame != null) {
            NotificationDialog notification = new NotificationDialog(message);
            notification.setLocationRelativeToOwner(mainFrame);
            notification.setVisible(true);
            SoundPlayer.play("/notifications/notification_info.wav");
        }
    }

    public static void showNotification(String message, int notificationType) {
        type = notificationType;
        if (mainFrame != null) {
            NotificationDialog notification = new NotificationDialog(message);
            notification.setLocationRelativeToOwner(mainFrame);
            notification.setVisible(true);
            System.out.println(notificationType);
            SoundPlayer.play("/notifications/notification_info.wav");
        }
    }

    public static JPanel getNotificationHeader() {
        JPanel northPanel = new JPanel();
        northPanel.setOpaque(true);
        northPanel.setBackground(new Color(28, 28, 51, 230));
        northPanel.setForeground(Color.WHITE);


        JLabel title = new JLabel("Notification");
        title.setIcon(new FlatSVGIcon(Notification.class.getResource("/icons/bell.svg")));
        title.setIconTextGap(10);
        title.setForeground(Color.WHITE);

        title.setFont(new Font(Font.DIALOG, Font.BOLD, 12));
        northPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        northPanel.add(title);
        return northPanel;
    }

    private static JPanel getNotificationBody(String message) {
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(new CompoundBorder(
                new MatteBorder(1, 0, 0, 0, new Color(60, 60, 75, 50)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        centerPanel.add(getNotificationTypeIcon(), BorderLayout.WEST);

        JPanel messagePanel = getMessagePanel(message);

        centerPanel.setOpaque(true);
        centerPanel.setBackground(new Color(28, 28, 51, 230));
        centerPanel.setForeground(Color.WHITE);
        centerPanel.add(messagePanel);
        return centerPanel;
    }

    private static JPanel getMessagePanel(String message) {
        JPanel messagePanel = new JPanel(new BorderLayout());
        messagePanel.setBackground(new Color(28, 28, 51, 0));
        messagePanel.setForeground(Color.WHITE);

        JTextArea messageContainer = new JTextArea(message);
        messageContainer.setWrapStyleWord(true);
        messageContainer.setLineWrap(true);
        messageContainer.setEditable(false);
        messageContainer.setOpaque(false);
        messageContainer.setForeground(Color.WHITE);
        messageContainer.setFont(new Font(Font.DIALOG, Font.PLAIN, 12));
        messagePanel.add(messageContainer, BorderLayout.CENTER);
        return messagePanel;
    }

    private static JPanel getContainer(String message) {

        JPanel container = new JPanel(new BorderLayout());
        container.setBorder(
                new MatteBorder(1, 1, 1, 1,
                        new Color(60, 60, 75, 100)
                ));
        container.setOpaque(true);
        container.setBackground(new Color(28, 28, 51, 230));
        container.setForeground(Color.WHITE);

        container.add(getNotificationHeader(), BorderLayout.NORTH);
        container.add(getNotificationBody(message), BorderLayout.CENTER);
        return container;
    }

    private static JPanel getNotificationTypeIcon() {

        JPanel iconPanel = new JPanel();
        JLabel icon = new JLabel();
        icon.setFont(new Font("Arial", Font.BOLD, 20));
        iconPanel.setBackground(new Color(28, 28, 51, 0));
        iconPanel.setForeground(Color.WHITE);
        String urlPath = null;

        if (type == Notification.SUCCESS) {
            urlPath = "icons/notification-success.svg";
        }
        if (type == Notification.ERROR) {
            urlPath = "icons/notification-error.svg";
        }
        if (type == Notification.INFO) {
            urlPath = "icons/notification-info.svg";
        }
        FlatSVGIcon svgIcon = new FlatSVGIcon(urlPath, 35, 35);
        icon.setIcon(svgIcon);
        iconPanel.add(icon);
        return iconPanel;
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

            Timer timer = new Timer(3000, e -> dispose());
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

            int notificationX = ownerX + ownerWidth - notificationWidth - 20;
            int notificationY = ownerY + ownerHeight - notificationHeight - 20;

            setLocation(notificationX, notificationY);
        }


    }
}
