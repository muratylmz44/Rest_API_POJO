package com.techprowed.pojos;

public class BookingPojo {

    private String firstname;
    private String lastname;
    private int Totalprice;
    private boolean depositpaid;
    private BookingDatesPojo bookingdates;   //Daha önce oluşturduğumuz pojo kalıbını datatype olarakbelirek
                                             //yeni pojonun içine gömmüş olduk.


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalprizce() {
        return Totalprice;
    }

    public void setTotalprizce(int totalprizce) {
        this.Totalprice = totalprizce;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public BookingDatesPojo getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(BookingDatesPojo bookingdates) {
        this.bookingdates = bookingdates;
    }

    public BookingPojo() {
    }

    public BookingPojo(String firstname, String lastname, int totalprizce, boolean depositpaid, BookingDatesPojo bookingdates) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.Totalprice = totalprizce;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
    }

    @Override
    public String toString() {
        return "BokingPojo{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprizce=" + Totalprice +
                ", depositpaid=" + depositpaid +
                ", bookingdates=" + bookingdates +
                '}';
    }
}
