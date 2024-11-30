import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard {
    private static JFrame frame;

    public static void main(String[] args) {
        frame = new JFrame("Revenue");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 700);
        frame.setLayout(new BorderLayout());

        // Bagian Header
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(10, 30, 70));
        headerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton homeButton = new JButton("Home");
        homeButton.setForeground(Color.BLACK);
        homeButton.setBackground(Color.WHITE);

        JButton getStartedButton = new JButton("Get Started");
        getStartedButton.setForeground(Color.WHITE);
        getStartedButton.setBackground(new Color(10, 30, 70));

        headerPanel.add(homeButton);
        headerPanel.add(getStartedButton);

        // Bagian Konten Utama
        JPanel contentPanel = new JPanel(new GridLayout(1, 2));
        contentPanel.setBackground(Color.WHITE);

        // Panel Kiri (Teks)
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(null);
        leftPanel.setBackground(Color.WHITE);

        // Judul utama
        JLabel titleLabel = new JLabel("REVENUE");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 72)); // Ukuran besar
        titleLabel.setBounds(50, 50, 600, 80); // Posisi disesuaikan
        titleLabel.setForeground(new Color(10, 30, 70));
        leftPanel.add(titleLabel);

        // Subtitle
        JLabel subtitleLabel = new JLabel("Platform Reservasi Venue Terlengkap di Lombok");
        subtitleLabel.setFont(new Font("SansSerif", Font.PLAIN, 24)); // Ukuran subtitle lebih besar
        subtitleLabel.setBounds(50, 150, 600, 40); // Posisi subtitle
        subtitleLabel.setForeground(new Color(50, 50, 50));
        leftPanel.add(subtitleLabel);

        // Deskripsi Parafrase (diperbaiki posisinya agar tidak tabrakan)
        JLabel descriptionLabel = new JLabel(
                "<html><center>Solusi terbaik untuk reservasi venue di Pulau Lombok, dengan sistem yang efisien dan akses informasi yang lengkap, memudahkan proses pemesanan Anda dengan cepat dan mudah.</center></html>");
        descriptionLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        descriptionLabel.setBounds(50, 200, 500, 100); // Lebar diperbesar dan tinggi disesuaikan
        descriptionLabel.setForeground(new Color(50, 50, 50));
        leftPanel.add(descriptionLabel);

        JButton startButton = new JButton("Get Started");
        startButton.setBounds(50, 320, 200, 50); // Tombol lebih besar
        startButton.setBackground(new Color(10, 30, 70)); // Ubah ke biru tua
        startButton.setForeground(Color.WHITE);
        startButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        leftPanel.add(startButton);

        // Panel Kanan (Gambar)
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBackground(Color.WHITE);

        // Mengatur ukuran gambar
        ImageIcon originalImage = new ImageIcon("aset/astroAwal.png");
        Image scaledImage = originalImage.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH); // Gambar
                                                                                                      // diperbesar
        ImageIcon resizedImage = new ImageIcon(scaledImage);

        JLabel astroLabel = new JLabel(resizedImage, JLabel.CENTER);
        astroLabel.setBounds(200, 150, 400, 400); // Gambar digeser lebih ke kanan
        rightPanel.add(astroLabel);

        contentPanel.add(leftPanel);
        contentPanel.add(rightPanel);

        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(contentPanel, BorderLayout.CENTER);

        // Event Listener untuk Get Started Button
        getStartedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll(); // Bersihkan semua elemen pada frame

                // Panel Pilihan Peran
                JPanel rolePanel = new JPanel();
                rolePanel.setBackground(Color.WHITE);
                rolePanel.setLayout(new BorderLayout());

                // Panel Kiri untuk Menampilkan Icon Back
                JPanel backPanel = new JPanel();
                backPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                backPanel.setBackground(Color.WHITE);

                // Tambahkan gambar icon back
                ImageIcon backIcon = new ImageIcon("aset/back.png");
                Image backImage = backIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                ImageIcon backResizedIcon = new ImageIcon(backImage);

                JButton backButton = new JButton(backResizedIcon);
                backButton.setBorder(BorderFactory.createEmptyBorder());
                backButton.setBackground(Color.WHITE);

                // Listener untuk tombol back
                backButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Kembali ke halaman utama (dashboard)
                        frame.getContentPane().removeAll(); // Hapus semua komponen
                        frame.add(headerPanel, BorderLayout.NORTH);
                        frame.add(contentPanel, BorderLayout.CENTER);
                        frame.revalidate();
                        frame.repaint(); // Repaint untuk menampilkan kembali halaman dashboard
                    }
                });

                backPanel.add(backButton);

                // Panel Pilihan User dan Provider
                JPanel optionPanel = new JPanel(new GridLayout(2, 1, 10, 10));
                optionPanel.setBackground(Color.WHITE);
                optionPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

                // Panel User
                JPanel userPanel = new JPanel();
                userPanel.setLayout(new BorderLayout());
                userPanel.setBackground(Color.WHITE);
                userPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

                ImageIcon userIcon = new ImageIcon("aset/hallo_user.2.png");
                Image userImage = userIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                ImageIcon userResizedIcon = new ImageIcon(userImage);

                JLabel userLabel = new JLabel(
                        "<html><center><b>Revenue</b><br>Hai, User! Kami senang melihat Anda di sini. Silakan login untuk menemukan venue yang sempurna untuk acara Anda.</center></html>",
                        userResizedIcon, JLabel.CENTER);
                userLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
                userLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                JButton userButton = new JButton("I am User");
                userButton.setBackground(new Color(10, 30, 70));
                userButton.setForeground(Color.WHITE);

                userPanel.add(userLabel, BorderLayout.CENTER);
                userPanel.add(userButton, BorderLayout.SOUTH);

                // Panel Provider
                JPanel providerPanel = new JPanel();
                providerPanel.setLayout(new BorderLayout());
                providerPanel.setBackground(Color.WHITE);
                providerPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

                ImageIcon providerIcon = new ImageIcon("aset/astroAwal.png");
                Image providerImage = providerIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                ImageIcon providerResizedIcon = new ImageIcon(providerImage);

                JLabel providerLabel = new JLabel(
                        "<html><center><b>Revenue</b><br>Selamat datang Provider! Kami siap membantu Anda mengelola venue Anda dengan lebih baik.</center></html>",
                        providerResizedIcon, JLabel.CENTER);
                providerLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
                providerLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                JButton providerButton = new JButton("I am Provider");
                providerButton.setBackground(new Color(10, 30, 70));
                providerButton.setForeground(Color.WHITE);

                providerPanel.add(providerLabel, BorderLayout.CENTER);
                providerPanel.add(providerButton, BorderLayout.SOUTH);

                optionPanel.add(userPanel);
                optionPanel.add(providerPanel);

                rolePanel.add(backPanel, BorderLayout.NORTH);
                rolePanel.add(optionPanel, BorderLayout.CENTER);

                frame.add(rolePanel);
                frame.revalidate();
                frame.repaint();
            }
        });

        frame.setVisible(true);
    }
}