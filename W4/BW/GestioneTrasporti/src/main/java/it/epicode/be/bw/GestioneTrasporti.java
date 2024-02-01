package it.epicode.be.bw;

import it.epicode.be.bw.dao.TitoloDiViaggioDAO;

public class GestioneTrasporti {

    public static void main(String[] args) {
        testVerificaTessera();
    }

    private static void popolaDb() {
    }

    private static void testVerificaTessera() {
        TitoloDiViaggioDAO tvDao = new TitoloDiViaggioDAO();
        Boolean verificaTessera = tvDao.verificaTessera("12345");
    }
}
