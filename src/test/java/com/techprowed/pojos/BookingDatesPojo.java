package com.techprowed.pojos;

public class BookingDatesPojo {



// private değişkenler oluşturduk
    private String checkin;
    private String checkout;

// Getter Setter oluşturduk
    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
    // Boş bir default constructor olusturduk
    public BookingDatesPojo() {
    }
    //kendi constructor oluşturuldu
    public BookingDatesPojo(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }
    //ToStrıing metodu oluşturuldu
    @Override
    public String toString() {
        return "BookingDatesPojo{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
