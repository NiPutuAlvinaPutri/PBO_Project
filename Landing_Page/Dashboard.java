package Landing_Page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard {
    private static JFrame frame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            frame = new JFrame("Revenue");

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1200, 700);
            frame.setLayout(new BorderLayout());
            frame.setBackground(Color.WHITE);

            // Header Panel
            JPanel headerPanel = createHeaderPanel();

            // Main Content Panel
            JPanel contentPanel = createMainContentPanel();

            frame.add(headerPanel, BorderLayout.NORTH);
            frame.add(contentPanel, BorderLayout.CENTER);

            frame.setVisible(true);
        });
    }

    // Create Header Panel
    private static JPanel createHeaderPanel() {
        // Header Panel dengan BorderLayout
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(10, 30, 70));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Tambahan untuk logo dan teks
        JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5)); // Panel untuk logo dan teks
        logoPanel.setBackground(new Color(10, 30, 70)); // Warna latar panel logo sesuai header

        // Menambahkan logo
        ImageIcon logoIcon = new ImageIcon("../asset/logo.png"); // Ambil logo dari folder "asset"
        Image scaledLogo = logoIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH); // Resize logo
        JLabel logoLabel = new JLabel(new ImageIcon(scaledLogo)); // Tambahkan logo ke JLabel
        logoPanel.add(logoLabel); // Tambahkan logo ke panel logo

        // Menambahkan teks "REVENUE"
        JLabel textLabel = new JLabel("REVENUE");
        textLabel.setFont(new Font("SansSerif", Font.BOLD, 20)); // Atur font teks
        textLabel.setForeground(Color.WHITE); // Warna teks
        textLabel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0)); // Tambahkan jarak 20px dari logo
        logoPanel.add(textLabel); // Tambahkan teks ke panel logo

        headerPanel.add(logoPanel, BorderLayout.WEST); // Tambahkan panel logo ke sisi kiri header

        // Panel untuk tombol navigasi di sisi kanan
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 5));
        buttonPanel.setBackground(new Color(10, 30, 70)); // Warna latar belakang sesuai dengan header

        // Tombol Home
        JButton homeButton = createStyledButton("Home", Color.WHITE, new Color(10, 30, 70));
        buttonPanel.add(homeButton);

        // Tombol Get Started
        JButton getStartedButton = createStyledButton("Get Started", Color.WHITE, new Color(10, 30, 70));
        getStartedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.add(createRoleSelectionPanel(headerPanel, createMainContentPanel()));
                frame.revalidate();
                frame.repaint();
            }
        });
        buttonPanel.add(getStartedButton);

        headerPanel.add(buttonPanel, BorderLayout.EAST); // Tambahkan tombol ke sisi kanan header

        return headerPanel;
    }

    // Create Main Content Panel
    private static JPanel createMainContentPanel() {
        JPanel contentPanel = new JPanel(new GridLayout(1, 2));
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        // Left Panel (Text)
        JPanel leftPanel = createLeftContentPanel();

        // Right Panel (Image)
        JPanel rightPanel = createRightContentPanel();

        contentPanel.add(leftPanel);
        contentPanel.add(rightPanel);

        return contentPanel;
    }

    // Create Left Content Panel
    private static JPanel createLeftContentPanel() {
        JPanel leftPanel = new JPanel(new GridBagLayout());
        leftPanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.anchor = GridBagConstraints.NORTHWEST;

        // Main Title
        JLabel titleLabel = new JLabel("REVENUE");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 60));
        titleLabel.setForeground(new Color(10, 30, 70));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        leftPanel.add(titleLabel, gbc);

        gbc.gridy++;
        // Subtitle
        JLabel subtitleLabel = new JLabel(
                "<html><div style='width:450px;text-align:left;'>Platform Reservasi Venue Terlengkap di Lombok</div></html>");
        subtitleLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        subtitleLabel.setForeground(new Color(70, 70, 90));
        leftPanel.add(subtitleLabel, gbc);

        gbc.gridy++;
        // Description
        JLabel descriptionLabel = new JLabel(
                "<html><div style='text-align: left; width: 450px;'>" +
                        "Solusi terbaik untuk reservasi venue di Pulau Lombok, dengan sistem yang efisien " +
                        "dan akses informasi yang lengkap, memudahkan proses pemesanan Anda dengan cepat dan mudah." +
                        "</div></html>");
        descriptionLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        descriptionLabel.setForeground(new Color(100, 100, 120));
        descriptionLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        leftPanel.add(descriptionLabel, gbc);

        gbc.gridy++;
        // Get Started Button
        JButton startButton = createGetStartedButton();
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.add(createRoleSelectionPanel(createHeaderPanel(), createMainContentPanel()));
                frame.revalidate();
                frame.repaint();
            }
        });
        leftPanel.add(startButton, gbc);

        return leftPanel;
    }

    // Create Right Content Panel
    private static JPanel createRightContentPanel() {
        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 0));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;

        ImageIcon originalImage = new ImageIcon("../asset/banner.png");
        Image scaledImage = originalImage.getImage().getScaledInstance(450, 450, Image.SCALE_SMOOTH);
        ImageIcon resizedImage = new ImageIcon(scaledImage);

        JLabel astroLabel = new JLabel(resizedImage, JLabel.CENTER);
        rightPanel.add(astroLabel, gbc);

        return rightPanel;
    }

    // Modified method to create Role Selection Panel
    private static JPanel createRoleSelectionPanel(JPanel headerPanel, JPanel previousContentPanel) {
        JPanel rolePanel = new JPanel(new BorderLayout());
        rolePanel.setBackground(Color.WHITE);

        JPanel backPanel = createBackPanel(headerPanel, previousContentPanel);

        JPanel optionPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Subtle gradient background
                GradientPaint gradient = new GradientPaint(
                        0, 0, new Color(240, 240, 250),
                        getWidth(), getHeight(), new Color(220, 230, 255));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g2d.dispose();
            }
        };
        optionPanel.setLayout(new GridBagLayout());
        optionPanel.setOpaque(false);
        optionPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 50, 50));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 20, 10, 20);

        JPanel userPanel = createEnhancedRolePanel(
                "asset/hallo_user.2.png ",
                "Revenue User",
                "Hai, User! Kami senang melihat Anda di sini. Silakan login untuk menemukan venue yang sempurna untuk acara Anda.",
                "I am User");

        JPanel providerPanel = createEnhancedRolePanel(
                "../asset/astroAwal.png",
                "Revenue Provider",
                "Selamat datang Provider! Kami siap membantu Anda mengelola venue Anda dengan lebih baik.",
                "I am Provider");

        gbc.gridx = 0;
        optionPanel.add(userPanel, gbc);

        gbc.gridx = 1;
        optionPanel.add(providerPanel, gbc);

        rolePanel.add(backPanel, BorderLayout.NORTH);
        rolePanel.add(optionPanel, BorderLayout.CENTER);

        return rolePanel;
    }

    // Enhanced Role Panel Creation Method
    private static JPanel createEnhancedRolePanel(String imagePath, String title, String description,
            String buttonText) {
        JPanel rolePanel = new JPanel(new BorderLayout(10, 10));
        rolePanel.setBackground(Color.WHITE);
        rolePanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 210, 230), 1, true),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)));

        // Image Panel
        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.setOpaque(false);
        ImageIcon roleIcon = new ImageIcon(imagePath);
        Image roleImage = roleIcon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        ImageIcon resizedRoleIcon = new ImageIcon(roleImage);
        JLabel roleLabel = new JLabel(resizedRoleIcon, JLabel.CENTER);
        imagePanel.add(roleLabel, BorderLayout.CENTER);

        // Text Panel
        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.setOpaque(false);

        // Title
        JLabel titleLabel = new JLabel(title, JLabel.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        titleLabel.setForeground(new Color(10, 30, 70));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        // Description
        JLabel roleDescription = new JLabel(
                "<html><div style='text-align: center; width: 300px;'>" + description + "</div></html>",
                JLabel.CENTER);
        roleDescription.setFont(new Font("SansSerif", Font.PLAIN, 14));
        roleDescription.setForeground(new Color(70, 70, 90));

        // Button
        JButton roleButton = new JButton(buttonText);
        roleButton.setBackground(new Color(10, 30, 70));
        roleButton.setForeground(Color.WHITE);
        roleButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        roleButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        roleButton.setPreferredSize(new Dimension(200, 50));
        roleButton.setFocusPainted(false);

        // Add shadow effect to button
        roleButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(10, 30, 70), 1, true),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)));

        textPanel.add(titleLabel, BorderLayout.NORTH);
        textPanel.add(roleDescription, BorderLayout.CENTER);
        textPanel.add(roleButton, BorderLayout.SOUTH);

        rolePanel.add(imagePanel, BorderLayout.NORTH);
        rolePanel.add(textPanel, BorderLayout.CENTER);

        // Add hover effect
        roleButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                roleButton.setBackground(new Color(30, 50, 90));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                roleButton.setBackground(new Color(10, 30, 70));
            }
        });

        return rolePanel;
    }

    // Create Back Panel
    private static JPanel createBackPanel(JPanel headerPanel, JPanel previousContentPanel) {
        JPanel backPanel = new JPanel(new BorderLayout(10, 10));
        backPanel.setBackground(Color.WHITE);
        backPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        JButton backButton = createBackButton(headerPanel, previousContentPanel);

        JLabel headerLabel = new JLabel("Masuk sebagai", JLabel.CENTER);
        headerLabel.setFont(new Font("SansSerif", Font.BOLD, 36));
        headerLabel.setForeground(new Color(10, 30, 70));

        backPanel.add(backButton, BorderLayout.WEST);
        backPanel.add(headerLabel, BorderLayout.CENTER);

        return backPanel;
    }

    // Create Back Button
    private static JButton createBackButton(JPanel headerPanel, JPanel previousContentPanel) {
        ImageIcon backIcon = new ImageIcon("../asset/back.png");
        Image backImage = backIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon backResizedIcon = new ImageIcon(backImage);

        JButton backButton = new JButton(backResizedIcon);
        backButton.setBorder(BorderFactory.createEmptyBorder());
        backButton.setBackground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.add(headerPanel, BorderLayout.NORTH);
                frame.add(previousContentPanel, BorderLayout.CENTER);
                frame.revalidate();
                frame.repaint();
            }
        });

        return backButton;
    }

    // Create Styled Button
    private static JButton createStyledButton(String text, Color foreground, Color background) {
        JButton button = new JButton(text);
        button.setForeground(foreground); // Warna teks default
        button.setBackground(background); // Warna background default
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setFocusPainted(false); // Hilangkan fokus berbentuk kotak
        button.setBorder(BorderFactory.createEmptyBorder()); // Hilangkan border default
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Atur efek hover pada teks
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                button.setForeground(new Color(255, 140, 0)); // Ubah warna teks ke oranye saat hover
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                button.setForeground(foreground); // Kembali ke warna teks asli
            }
        });

        return button;
    }

    // Create Get Started Button
    private static JButton createGetStartedButton() {
        JButton button = new JButton("Get Started");
        Color defaultBackground = new Color(10, 30, 70); // Warna latar default
        Color hoverBackground = Color.WHITE; // Warna latar saat hover
        Color defaultForeground = Color.WHITE; // Warna teks default
        Color hoverForeground = new Color(10, 30, 70); // Warna teks saat hover
        Color borderColor = new Color(10, 30, 70); // Warna border (sama dengan warna latar default)

        button.setBackground(defaultBackground);
        button.setForeground(defaultForeground);
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setFocusPainted(false);

        // Set border dengan warna biru tua
        button.setBorder(BorderFactory.createLineBorder(borderColor, 2));

        // Atur efek hover pada tombol
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                button.setBackground(hoverBackground);
                button.setForeground(hoverForeground);
                button.setBorder(BorderFactory.createLineBorder(borderColor, 2)); // Tetap gunakan border biru tua
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                button.setBackground(defaultBackground);
                button.setForeground(defaultForeground);
                button.setBorder(BorderFactory.createLineBorder(borderColor, 2)); // Kembalikan ke border aslinya
            }
        });

        return button;
    }

}