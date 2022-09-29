package com.company;

/**
 * Project 2 -- Cipher
 *
 * This is an implementation of encryption and decryption algorithms of a
 * substitution cipher
 *
 * @author Emirhan Simsek
 *
 * @class BIL 122
 *
 * @date 06.04.2021   17.41
 *
 */

public class Cipher {

    final String plaintextAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; // Plaintext
    // Alphabet
    private String keyword; // The Secret Keyword
    private String ciphertextAlphabet;// Ciphertext Alphabet

    /**
     * Class constructor initializes the keyword and creates the Ciphertext Alphabet
     *
     * @param key the secret keyword used to create the ciphertext alphabet
     */
    public Cipher(String key) {
        this.keyword=key;
        this.ciphertextAlphabet=initCiphertextAlphabet();

    }

    /**
     * removes all duplicate occurrences of characters from a String
     *
     * @param s String with duplicate occurrences of characters
     * @return String with no duplicate characters in it
     */
    public static String removeDups(String s)
    {
        String sonuc="";

        for(int i=0;i<s.length();i++)// keywordun icinde dolasabilmek icin
        {
            if(sonuc.indexOf(s.charAt(i))==-1)//Eger keyword daki harfler tekrar etmiyorsa -1 doner ve sonuc a ekler
            {
                sonuc=sonuc+s.charAt(i);
            }
        }

        return sonuc;
    }

    /**
     * generates the ciphertext alphabet from the keyword
     *
     * @return String of ciphertext alphabet generated from the keyword
     */
    public String initCiphertextAlphabet() {
        String ptA=plaintextAlphabet;
        String str=keyword.toUpperCase();
        str=removeDups(str);


        for(int a=0;a<ptA.length();a++)//alfabenin tum harflerini gezebilmek icin
        {
            if(str.indexOf(ptA.charAt(a))==-1)//Plaintext alfabedeki harfi keyword da gorurse -1 dondurur ve Ciphertext alfabeye ekler
            {
                str+=ptA.charAt(a);
            }
        }

        return str;
    }

    /**
     * Encrypts a message in plaintext
     *
     * @param message the message to be encrypted in ciphertext alphabet
     * @return the encrypted message in ciphertext alphabet
     */
    public String encrypt(String message) {
        String msg=message;
        msg=message.toUpperCase();
        String str1="";
        String ctA=ciphertextAlphabet;
        String ptA=plaintextAlphabet;
        int k;

        for(int i=0;i<msg.length();i++)
        {
            char msgLetter=msg.charAt(i);//Sifrelenecek mesajin harflerini tutar
            k=ptA.indexOf(msgLetter);//Eslesme yapabilmek icin mesajin Plaintext alfabede kacinci sirada oldugunu tutar
            if(k==-1)// Eger mesajdaki bir karakter Plaintext alfabede bulunmuyor ise k=-1 olur ve o karakteri dogrudan sifreli mesaja ekler
            {
                str1+=msgLetter;
            }
            else//harf bulunduysa o harfin sirasini Ciphertext alfabedeki harfle eslestirir ve Ciphertext alfabedeki harfi sifreli mesaja ekler
            {
                str1+=ctA.charAt(k);
            }

        }




        return str1;
    }

    /**
     * Encrypts a message in plaintext
     *
     * @param ciphertext ciphertext in ciphertext alphabet
     * @return the decrypted message in plaintext alphabet
     */
    public String decrypt(String ciphertext) {
        String cpt=ciphertext;
        cpt=ciphertext.toUpperCase();
        String str1="";
        String ctA=ciphertextAlphabet;
        String ptA=plaintextAlphabet;
        int m;

        for(int i=0;i<cpt.length();i++)// Ciphertext alfabede dolasabilmek icin
        {
            char cptLetter=cpt.charAt(i);// Verilen sifreli mesajin harflerini tutar
            m=ctA.indexOf(cptLetter);//Eslesme yapabilmek icin sifreli mesajin harflerinin Ciphertext alfabedeki sirasini tutar
            if(m==-1)//Eger sifreli mesajdaki karakter Ciphertext alfabede yoksa m=-1 olur ve o karakteri dogrudan sifresi cozulmus mesaja ekler
            {
                str1+=cptLetter;
            }
            else//Harf bulunduysa o harfin sirasini Plaintext alfabedeki harfle eslestirir ve sifresi cozulmus mesaja ekler
            {
                str1+=ptA.charAt(m);

            }
        }

        return str1;
    }

}