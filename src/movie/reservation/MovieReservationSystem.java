/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movie.reservation;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class MovieReservationSystem extends JFrame {
    private JLabel moviePosterLabel;
    private JLabel movieTitleLabel;
    private JLabel movieDurationLabel;
    private int currentMovieIndex = 0;
    private BackgroundPanel moviePosterPanel;
    private double selectedMoviePrice;
    MovieInfo movieInfo = new MovieInfo();

     private MovieData[] movies = new MovieData[] {
        new MovieData("Moana 2", "1 hr 40 mins", "bbb.jpg", 350.00), //0
        new MovieData("Hello, Love, Again", "2 hrs 10 mins", "aaa.jpg", 320.00), //1
        new MovieData("Wicked", "1 hr 55 mins", "ccc.jpg", 330.00) //3
    };

    public MovieReservationSystem() {
        setTitle("Movie Reservation System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 670);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(40, 40, 40));

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(40, 40, 40));

        JPanel movieInfoPanel = new JPanel(new GridBagLayout());
        movieInfoPanel.setBackground(new Color(40, 40, 40));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        movieTitleLabel = new JLabel("", SwingConstants.CENTER);
        movieTitleLabel.setForeground(Color.WHITE);
        movieTitleLabel.setFont(new Font(movieTitleLabel.getFont().getName(), Font.BOLD, 20));

        movieDurationLabel = new JLabel("", SwingConstants.CENTER);
        movieDurationLabel.setForeground(Color.WHITE);

        JPanel posterNavPanel = new JPanel(new BorderLayout());
        posterNavPanel.setBackground(new Color(40, 40, 40));

        moviePosterPanel = new BackgroundPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Deep blue gradient background
                Graphics2D g2d = (Graphics2D) g.create();
                GradientPaint gradient = new GradientPaint(
                    0, 0, new Color(10, 20, 50),   // Dark navy blue
                    0, getHeight(), new Color(30, 40, 70)  // Slightly lighter navy blue
                );
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g2d.dispose();
            }
        };
        moviePosterLabel = new JLabel();
        moviePosterLabel.setPreferredSize(new Dimension(400, 500));
        moviePosterLabel.setHorizontalAlignment(SwingConstants.CENTER);
        moviePosterPanel.add(moviePosterLabel);

        JPanel navigationPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        navigationPanel.setBackground(new Color(40, 40, 40));
        JButton prevButton = new JButton("<");
        prevButton.setBackground(new Color(80, 80, 80));
        prevButton.setForeground(Color.WHITE);
        prevButton.addActionListener(e -> {
            currentMovieIndex = (currentMovieIndex - 1 + movies.length) % movies.length;
            updateMoviePoster();
        });
        JButton nextButton = new JButton(">");
        nextButton.setBackground(new Color(80, 80, 80));
        nextButton.setForeground(Color.WHITE);
        nextButton.addActionListener(e -> {
            currentMovieIndex = (currentMovieIndex + 1) % movies.length;
            updateMoviePoster();
        });
        navigationPanel.add(prevButton);
        navigationPanel.add(nextButton);
   
       

        posterNavPanel.add(moviePosterPanel, BorderLayout.CENTER);
        posterNavPanel.add(navigationPanel, BorderLayout.SOUTH);

        mainPanel.add(posterNavPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(new Color(40, 40, 40));

        JButton bookTicketButton = new JButton("Book a Ticket");
        bookTicketButton.setBackground(new Color(255, 140, 0));
        bookTicketButton.setForeground(Color.WHITE);
        bookTicketButton.addActionListener(e -> {
        int currentIndex = movieInfo.getCurrentMovieIndex();  // Use movieInfo
        movieInfo.setSelectedMoviePrice(movies[currentIndex].getPrice()); // Access price from movies array
        new MovieReservationSystemGUI(movies[currentIndex].getTitle(), currentIndex, movieInfo.getSelectedMoviePrice(), this).setVisible(true);  // Pass 'this' and all required data
    });
        
        bottomPanel.add(bookTicketButton, BorderLayout.NORTH);

        movieInfoPanel.add(movieTitleLabel, gbc);
        movieInfoPanel.add(movieDurationLabel, gbc);
        bottomPanel.add(movieInfoPanel, BorderLayout.SOUTH);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
         
       
        
        add(mainPanel);
        updateMoviePoster();
    }

    private void updateMoviePoster() {
        try {
            String imagePath = movies[currentMovieIndex].posterPath;
            File imageFile = new File("C:\\Users\\Techsavvy\\OneDrive\\Documents\\NetBeansProjects\\movie reservation\\src\\movie\\reservation\\" + imagePath);

            if (!imageFile.exists()) {
                System.err.println("Could not find image: " + imageFile.getAbsolutePath());
                return;
            }

            BufferedImage img = ImageIO.read(imageFile);
            if (img == null) {
                System.err.println("Image could not be loaded: " + imagePath);
                return;
            }

            movieTitleLabel.setText(movies[currentMovieIndex].title);
            movieDurationLabel.setText(movies[currentMovieIndex].duration);
            movieInfo.setCurrentMovieIndex(currentMovieIndex);

            double aspectRatio = (double) img.getWidth() / img.getHeight();
            int newHeight = 500;
            int newWidth = (int) (newHeight * aspectRatio);
            Image scaledImage = img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

            moviePosterLabel.setIcon(new ImageIcon(scaledImage));
            moviePosterPanel.repaint();

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading image: " + e.getMessage());
        }
    }


    private class BackgroundPanel extends JPanel {
        private Image backgroundImage;
        public BackgroundPanel() {/*Do nothing*/}

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MovieReservationSystem().setVisible(true));
    }
}