/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movie.reservation;

public class MovieInfo {
    private int currentMovieIndex = 0;
    private double selectedMoviePrice;
    private String customerName;
    

    public int getCurrentMovieIndex() {
        return currentMovieIndex;
    }

    public void setCurrentMovieIndex(int currentMovieIndex) {
        this.currentMovieIndex = currentMovieIndex;
    }

    public double getSelectedMoviePrice() {
        return selectedMoviePrice;
    }

    public void setSelectedMoviePrice(double selectedMoviePrice) {
        this.selectedMoviePrice = selectedMoviePrice;
    }
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName; // Now sets the customerName field
    }
    
    
            
    
    
}
