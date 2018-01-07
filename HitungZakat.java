import java.util.Scanner;
public class HitungZakat {
	/*
	Program sederhana untuk menghitung zakat mal
	sebagai tugas Mini Project mata kuliah Dasar Pemrograman
	Prodi Sistem Komputer Fakultas MIPA Universitas Tanjung Pura
	
	oleh Kelompok 7:
	1. Dwi Kusumayani
	2. Fathan Wirawan
	3. Ibnu Jihad A.
	4. M. Azmi Aulia Amin
	5. Rama Pratama */
   
    static float totalZakatPerhiasan, totalZakatPertanian, totalZakatTemuan, hitung;
    static int hargaEmas=555000, hargaPerak=11000, iEmas, iPerak, iTabungan, iHutang, iPanen, tanya, iKarun;
    static Scanner input = new Scanner (System.in);
   
    static float hitung_zakatPerhiasan(int emas, int perak, int tabungan, int hutang)
    {
        totalZakatPerhiasan = (emas + perak + tabungan + hutang)*0.025f;
        return totalZakatPerhiasan;
    }
    static float hitung_zakatPertanian(int panen, float hitungan){
        totalZakatPertanian = panen*hitungan;
        return totalZakatPertanian;
    }
   
    static float hitung_zakatTemuan(int karun){
        totalZakatTemuan = karun*0.2f;
        return totalZakatTemuan;
    }
       
    public static void tampilan (){
    byte menu;
       
        System.out.println("================== HITUNG ZAKAT MAL ==================");
        System.out.println("1.) Perhiasan dan Uang.\n2.) Pertanian.\n3.) Harta Temuan.");
        System.out.print("\nPilih jenis Wajib Zakat Mal: ");
        menu = input.nextByte();
        switch (menu) {
        case 1:
            System.out.print("Total tabungan anda: Rp.");
            iTabungan = input.nextInt();
            System.out.print("Total hutang anda: Rp.");
            iHutang = input.nextInt();
            System.out.print("Total gram emas anda: ");
            iEmas = input.nextInt();
            if (iEmas>=85) iEmas *= hargaEmas; //nisab emas adalah 85 gram
            else {
                iEmas=0;
                System.out.println("Nisab belum terpenuhi.");
            }
            System.out.print("Total gram perak anda: ");
            iPerak = input.nextInt();
            if (iPerak>=595) iPerak *= hargaPerak; //nisab perak adalah 85 gram
            else {
                iPerak=0;
                System.out.println("Nisab belum terpenuhi.");
            }
            if (hitung_zakatPerhiasan(iEmas, iPerak, iTabungan, iHutang)>hargaEmas) {
                System.out.println("Total harga perhiasan wajib zakat anda: Rp." + hitung_zakatPerhiasan(iEmas, iPerak, iTabungan, iHutang) + "-.");
                ulangi();
            }
            else {
                System.out.println("\nAnda kurang kaya untuk membayar zakat.");
                ulangi();
            }
       
        break;
        case 2:
            System.out.print("Hasil panen dalam setahun (kilogram): ");
            iPanen = input.nextInt();
            if (iPanen>=650) {
            byte cara;
            System.out.println("Bagaimana cara pengairan pertanian:\n1.) Alami.\n2.) Manual/Dengan tenaga.");
            cara = input.nextByte();
            switch (cara) {
            case 1:
            hitung = 0.1f;
            System.out.println("Total wajib zakat pertanian anda: " + hitung_zakatPertanian(iPanen, hitung) + " kg");
            ulangi();
            break;
            case 2:
            hitung = 0.05f;
            System.out.println("Total wajib zakat pertanian anda: " + hitung_zakatPertanian(iPanen, hitung) + " kg");
            ulangi();
            break;
            default :
            System.out.println("\nTidak ada pilihan ketiga, anda jangan maksa.");
            ulangi();
            }
            }
            else {
                System.out.println("Anda kurang sukses menjadi petani.");
                ulangi();
            }
            break;
        case 3:
            System.out.print("Jumlah harta karun yang anda temukan: Rp.");
            iKarun = input.nextInt();
            if (iKarun>0) {
                System.out.println("Total wajib zakat harta temuan anda: Rp." + hitung_zakatTemuan(iKarun) + "-");
                ulangi();
            }
            else { System.out.println("\nBeneran segitu? Duh kasihan.");
            ulangi();
            }
            break;
        default:
        {
            salah();
            tampilan();
        }
    }
    }
    static void ulangi ()
    {
        System.out.println("\nKembali ke Menu?\n1.) Ya.\n2.) Tidak.");
        tanya = input.nextInt();
        if ( tanya == 1)
        tampilan();
        if ( tanya == 2)
        System.exit(0);
        else
        {
            salah();
            ulangi();
        }
    }
    static void salah ()
    {
        System.out.println("\n======= !!! Input salah, mohon ulangi lagi !!! ======= \n");
    }
    public static void main (String [] args)
    {
        tampilan();
        }
}