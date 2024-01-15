package it.epicode.be.classi;

import it.epicode.be.classi.base.ElementoMultimediale;
import it.epicode.be.classi.base.ElementoMultimedialeRiproducibile;
import it.epicode.be.classi.concrete.Audio;
import it.epicode.be.classi.concrete.Immagine;
import it.epicode.be.classi.concrete.Video;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class LettoreMultimediale {
    private static final int DIMENSIONE_LISTA_ELEMENTI = 2;

    private ElementoMultimediale[] listaElementi;

    /**
     * @param args
     */
    public static void main(String[] args) {

        LettoreMultimediale player = new LettoreMultimediale();

        player.start();

    }

    private void caricaListaElementi() {
        listaElementi = new ElementoMultimediale[DIMENSIONE_LISTA_ELEMENTI];
        System.out.println("*****          Caricamento lista elementi          *****");

        for (int i = 0; i < listaElementi.length; i++) {
            ElementoMultimediale elemento = caricaElemento();
            if (elemento != null) {
                listaElementi[i] = elemento;
                System.out.println("Elemento " + i + " caricato con successo");
            } else {
                System.out.println("Elemento " + i + " non caricato, riprovare");

                i = i - 1;

            }

        }
        System.out.println("*****          Caricamento completato              *****");

    }

    private ElementoMultimediale caricaElemento() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Scegli il tipo elemento inserendo il numero corrispondente seguito dal tasto Invio:");
        System.out.println("> 1 - Video");
        System.out.println("> 2 - Audio");
        System.out.println("> 3 - Immagine");
        int scelta = scanner.nextInt();

        ElementoMultimediale elemento = null;
        switch (scelta) {
            case 1: {
                elemento = caricaVideo();
                break;
            }
            case 2: {
                elemento = caricaAudio();
                break;
            }
            case 3: {
                elemento = caricaImmagine();
                break;
            }
            default:
                System.out.println("Selezione non valida");
        }

        return elemento;

    }

    private Immagine caricaImmagine() {

        System.out.println("- Inserisci il titolo dell'immagine seguito dal tasto Invio");
        Scanner scanner = new Scanner(System.in);
        String titolo = scanner.nextLine();
        System.out.println("- Inserisci la luminosità dell'immagine seguita dal tasto Invio");
        int luminosita = scanner.nextInt();

        Immagine newImg = new Immagine(titolo, luminosita);
        return newImg;

    }

    private Audio caricaAudio() {
        System.out.println("- Inserisci il titolo dell'audio seguito dal tasto Invio");
        Scanner scanner = new Scanner(System.in);
        String titolo = scanner.nextLine();
        System.out.println("- Inserisci la durata dell'audio seguita dal tasto Invio");
        int durata = scanner.nextInt();
        System.out.println("- Inserisci il volume dell'audio seguito dal tasto Invio");
        int volume = scanner.nextInt();

        Audio newAudio = new Audio(titolo, durata, volume);
        return newAudio;
    }

    private Video caricaVideo() {
        System.out.println("- Inserisci il titolo del video seguito dal tasto Invio");
        Scanner scanner = new Scanner(System.in);
        String titolo = scanner.nextLine();
        System.out.println("- Inserisci la durata del video seguita dal tasto Invio");
        int durata = scanner.nextInt();
        System.out.println("- Inserisci il volume del video seguito dal tasto Invio");
        int volume = scanner.nextInt();
        System.out.println("- Inserisci la luminosità del video seguita dal tasto Invio");
        int luminosita = scanner.nextInt();

        Video newVideo = new Video(titolo, durata, volume, luminosita);
        return newVideo;
    }

    private ElementoMultimediale selezionaElemento() {
        System.out.println();
        System.out.println("*****          Riproduzione elemento              *****");
        System.out.println("Seleziona l'elemento inserendo un valore da 1 a " + listaElementi.length
                + " - inserisci 0 per uscire");
        Scanner scanner = new Scanner(System.in);
        int selezione = scanner.nextInt();

        if (selezione == 0) {
            return null;
        } else {
            return listaElementi[selezione - 1];
        }

    }

    public void start() {
        caricaListaElementi();

        boolean eseguiPlayer = true;
        do {
            ElementoMultimediale elementoSelezionato = selezionaElemento();

            if (elementoSelezionato instanceof ElementoMultimedialeRiproducibile) {
                ((ElementoMultimedialeRiproducibile) elementoSelezionato).play();
            } else if (elementoSelezionato instanceof Immagine) {
                ((Immagine) elementoSelezionato).show();

            } else if (elementoSelezionato == null) {
                eseguiPlayer = false;
            }

        } while (eseguiPlayer);
        System.out.println("*****          Player chiuso con successo              *****");

    }
}