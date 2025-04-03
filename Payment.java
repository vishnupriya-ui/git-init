public class Payment {
    private String customerName;
    private String serviceType;
    private double cost;
    private boolean isPaid;

    public Payment(String customerName, String serviceType, double cost) {
        this.customerName = customerName;
        this.serviceType = serviceType;
        this.cost = cost;
        this.isPaid = false;
    }

    public String makePayment(double paymentAmount) {
        if (paymentAmount >= cost) {
            isPaid = true;
            return "Payment successful! Thank you, " + customerName + ". Enjoy the " + serviceType + " service.";
        } else {
            return "Payment failed! Amount due: $" + String.format("%.2f", cost - paymentAmount);
        }
    }

    public String paymentStatus() {
        return isPaid ? "Paid" : "Pending";
    }

    // Example usage
    public static void main(String[] args) {
        Payment payment1 = new Payment("John Doe", "Full Grooming", 50.00);
        System.out.println(payment1.paymentStatus());  // Output: Pending
        System.out.println(payment1.makePayment(30.00)); // Output: Payment failed! Amount due: $20.00
        System.out.println(payment1.makePayment(50.00)); // Output: Payment successful! Thank you, John Doe. Enjoy the Full Grooming service.
        System.out.println(payment1.paymentStatus());  // Output: Paid
    }
}