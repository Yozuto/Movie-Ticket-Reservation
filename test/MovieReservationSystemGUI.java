import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MovieReservationSystemGUI extends JFrame {
    private static final int ROWS = 10;
    private static final int COLS = 10;
    private boolean[][] seatState = new boolean[ROWS][COLS];
    private JButton[][] seatButtons = new JButton[ROWS][COLS];
    private JLabel ticketsLabel, totalLabel;
    private int selectedSeats = 0;

    public MovieReservationSystemGUI() {
        setTitle("Movie Reservation System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Seating chart
        JPanel seatingChart = new JPanel(new GridLayout(ROWS, COLS, 2, 2));
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                JButton seatButton = new JButton(String.format("%d,%d", row + 1, col + 1));
                final int r = row, c = col;
                seatButton.addActionListener(e -> toggleSeat(r, c));
                seatButtons[row][col] = seatButton;
                seatingChart.add(seatButton);
            }
        }
        add(seatingChart, BorderLayout.CENTER);

        // Booking details
        JPanel bookingDetails = new JPanel(new GridLayout(0, 1, 10, 10));
        bookingDetails.add(new JLabel("Movie: Gingerdown"));
        bookingDetails.add(new JLabel("Time: April 03, 21:00"));
        ticketsLabel = new JLabel("Tickets: 0");
        bookingDetails.add(ticketsLabel);
        totalLabel = new JLabel("Total: 0 LKR");
        bookingDetails.add(totalLabel);
        JButton bookButton = new JButton("Book Now");
        bookButton.addActionListener(e -> showConfirmation());
        bookingDetails.add(bookButton);
        add(bookingDetails, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void toggleSeat(int row, int col) {
        seatState[row][col] = !seatState[row][col];
        updateSeatingChart();
        updateBookingDetails();
    }

    private void updateSeatingChart() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (seatState[row][col]) {
                    seatButtons[row][col].setBackground(Color.GREEN);
                } else {
                    seatButtons[row][col].setBackground(Color.GRAY);
                }
            }
        }
    }

    private void updateBookingDetails() {
        selectedSeats = 0;
        for (boolean[] row : seatState) {
            for (boolean seat : row) {
                if (seat) {
                    selectedSeats++;
                }
            }
        }
        ticketsLabel.setText("Tickets: " + selectedSeats);
        totalLabel.setText("Total: " + (selectedSeats * 10) + " LKR");
    }

    private void showConfirmation() {
        if (selectedSeats > 0) {
            // Show confirmation dialog
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MovieReservationSystemGUI::new);
    }
}