
/**
 * Write a description of class Part1 here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part1 {

    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        int index = 0;
        int startPosition = startIndex + 3;
        while (index != -1) {
            index = dna.indexOf(stopCodon, startPosition);
            if (index % 3 == 0) {
                return index;
            }
            startPosition = index + 1;
        }

        return dna.length();
    }

    public void testFindStopCodon() {
        // Has gene
        System.out.println(findStopCodon("atggatcctccatatacaacggta", 3, "gta"));
        // Does not have
        System.out.println(findStopCodon("ctccacctcaggtttagat", 5, "gta"));
    }

    public String findGene(String dna) {
        int startCodon = dna.indexOf("atg");
        if (startCodon == -1) {
            return "";
        }
        int stopCodonTAA = findStopCodon(dna, startCodon, "taa");
        int stopCodonTAG = findStopCodon(dna, startCodon, "tag");
        int stopCodonTGA = findStopCodon(dna, startCodon, "tga");
        int stopCodon = 0;
        if (stopCodonTAA > stopCodonTAG && stopCodonTAA > stopCodonTGA) {
            stopCodon = stopCodonTAA;
        } else if (stopCodonTAG > stopCodonTAA && stopCodonTAG > stopCodonTGA) {
            stopCodon = stopCodonTAG;
        } else {
            stopCodon = stopCodonTGA;
        }
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
        System.out.println("Should be atgcagtaagtttag -> " + findGene("ctccagctagcctgaatgcagtaagtttactga"));
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
}
