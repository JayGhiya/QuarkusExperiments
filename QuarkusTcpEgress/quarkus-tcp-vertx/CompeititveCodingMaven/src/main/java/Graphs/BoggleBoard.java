package Graphs;

import java.util.*;

public class BoggleBoard {

    static class TrieNode {

        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        String word;

    }

    static class Trie {

        public TrieNode root;

        public char endOfWord;

        public Trie() {
            this.root = new TrieNode();
            endOfWord = '*';
        }

        public void addWord(String word) {
            TrieNode node = this.root;
            for (int i = 0; i < word.length(); i++) {
                char element = word.charAt(i);

                if (!node.children.containsKey(element)) {
                    TrieNode newElement = new TrieNode();
                    node.children.put(element, newElement);
                }

                node = node.children.get(element);
            }

            //add end of string and word
            node.children.put('*', null);
            node.word = word;

        }

    }

    public static List<String> boggleBoard(char[][] board, String[] words) {

        Trie stringDs = new Trie();
        //let us first construct a trie
        for (String word : words) {
            stringDs.addWord(word);
        }
        //now let us explore the matrix and
        //let us have a boolean matrix first
        boolean[][] booleanboard = new boolean[board.length][board[0].length];
        //final list of words that are present
        //construct a set where no repeatitive words are not added
        Set<String> finalWords = new HashSet<String>();

        //let us iterte through matrix
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //function to explore current index
                explore(i, j, board, booleanboard, stringDs.root, finalWords);
            }
        }


        List<String> resultWords = new ArrayList<>();

        resultWords.addAll(finalWords);
        return resultWords;
    }

    public static void explore(int i, int j, char[][] board, boolean[][] booleanboard, TrieNode root, Set<String> finalStrings) {
        //do dfs
        // check first if the node is already visited
        if (booleanboard[i][j]) {
            return;
        }
        //check whether it is present in any of the children of node of trie root if not return otherwise does not make sense to go further
        char character = board[i][j];
        if (!root.children.containsKey(character)) {
            return;
        }
        //then check whether we have reached end of string then add to list of finalStrings
        //set as visited first
        booleanboard[i][j] = true;
        root = root.children.get(character);
        if (root.children.containsKey('*')) {
            finalStrings.add(root.word);
        }

        //get neighbours of current element
        List<Integer[]> neighbours = getNeighbours(i, j, board);

        for (Integer[] neighbour : neighbours) {

            explore(neighbour[0], neighbour[1], board, booleanboard, root, finalStrings);
        }

        booleanboard[i][j] = false;

    }

    public static List<Integer[]> getNeighbours(int i, int j, char[][] board) {
        List<Integer[]> neighbours = new ArrayList<>();

        //top left
        if ((i - 1 >= 0) && (j - 1 >= 0)) {
            neighbours.add(new Integer[]{i - 1, j - 1});
        }

        //top right
        if ((i - 1 >= 0) && (j + 1 < board[0].length)) {
            neighbours.add(new Integer[]{i - 1, j + 1});
        }

        //top
        if ((i - 1) >= 0) {
            neighbours.add(new Integer[]{i - 1, j});
        }

        //left
        if ((j - 1) >= 0) {
            neighbours.add(new Integer[]{i, j - 1});
        }

        //right
        if ((j + 1) < board[0].length) {
            neighbours.add(new Integer[]{i,j+1});
        }

        //bottom left
        if( (i+1)< board.length && (j-1)>=0)
        {
            neighbours.add(new Integer[]{i+1,j-1});
        }

        //bottom
        if( (i+1)<board.length )
        {
            neighbours.add(new Integer[]{i+1,j});
        }

        //bottom right
        if( (i+1)<board.length &&  (j+1)<board[0].length )
        {
            neighbours.add(new Integer[]{i+1,j+1});
        }


        return neighbours;
    }

}
