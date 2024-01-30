public class Part3 {

    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        int index = 0;
        int startPosition = startIndex + 3;
        while (index != -1) {
            index = dna.indexOf(stopCodon, startPosition);
            if ((index - startIndex) % 3 == 0) {
                return index;
            }
            startPosition = index + 1;
        }

        return index;
    }

    public void testFindStopCodon() {
        // Has gene
        System.out.println(findStopCodon("atggatcctccatatacaacggta", 3, "gta"));
        // Does not have
        System.out.println(findStopCodon("ctccacctcaggtttagat", 5, "gta"));
    }

    public String findGene(String dna) {
        int startCodon = dna.indexOf("ATG");
        System.out.println("Start" + startCodon);
        if (startCodon == -1) {
            return "";
        }
        int stopCodonTAA = findStopCodon(dna, startCodon, "TAA");
        int stopCodonTAG = findStopCodon(dna, startCodon, "TAG");
        int stopCodonTGA = findStopCodon(dna, startCodon, "TGA");
        int stopCodon = 0;
        if (stopCodonTAA < stopCodonTAG && stopCodonTAA < stopCodonTGA && stopCodonTAA != -1) {
            stopCodon = stopCodonTAA;
        } else if (stopCodonTAG < stopCodonTAA && stopCodonTAG < stopCodonTGA && stopCodonTAG != -1) {
            stopCodon = stopCodonTAG;
        } else {
            stopCodon = stopCodonTGA;
        }
        System.out.println("End" + stopCodon);
        // If there is no gene
        if (stopCodon == -1) {
            return "";
        }
        return dna.substring(startCodon, stopCodon + 3);
    }

    public void testFindGene() {
        // Has all end codons
        System.out.println("Should be atggatccttaa -> " + findGene("atggatccttaatgatagacggta"));
        // Does not have start codon
        System.out.println("Should be an empty string -> " + findGene("ctccacctcaggtttagat"));
        // Does not have end codon
        System.out.println("Should be an empty string -> " + findGene("ctccagatgctagcctcaggtttagat"));
        // Does not have TAA
        System.out.println("Should be atgctagcctga -> " + findGene("ctccagatgctagcctgacagtaggtttagat"));
        // Does not have TGA
        System.out.println("Should be atgcagtaagtttag -> " + findGene("ctccagctagcctgaatgcagtaagtttagat"));
        // Does not have TAG
        System.out.println("Should be atgcagtaagtttag -> " + findGene("ctccagctagcctgaatgcagtaagtttagtga"));
    }

    public void printAllGenes(String dna) {
        String dnaLeft = dna;
        String currGene = "";
        while (dnaLeft != "") {
            currGene = findGene(dnaLeft);
            if (currGene == "") {
                dnaLeft = "";
            }
            System.out.println(currGene);
            dnaLeft = dnaLeft.substring(currGene.length());
        }
    }

    public int countGenes(String dna) {
        String dnaLeft = dna;
        int numOfGenes = 0;
        String currGene = "";
        while (dnaLeft != "") {
            currGene = findGene(dnaLeft);
            if (currGene == "") {
                dnaLeft = "";
            } else {
                numOfGenes = numOfGenes + 1;
                dnaLeft = dnaLeft.substring(currGene.length());
            }
        }
        return numOfGenes;
    }

    public void testCountGenes() {
        // Has 2
        System.out.println("Should have 2 -> " + countGenes("atggatccttaatgatgagacggta"));
        // Does not have
        System.out.println("Should not have any -> " + countGenes("ctccagatgctagcctcaggtttagat"));
        // Has 1
        System.out.println("Should have 1 -> " + countGenes("ctccagatgctagcctgacagtaggtttagat"));
    }
}
