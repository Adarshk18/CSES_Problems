import java.util.*;

public class ShortenArray {
    static class Node {
        Node[] links = new Node[2];
        int maxIndex = -1;

        boolean containsKey(int bit) {
            return links[bit] != null;
        }

        Node get(int bit) {
            return links[bit];
        }

        void put(int bit, Node node) {
            links[bit] = node;
        }
    }

    static class Trie {
        Node root;

        Trie() {
            root = new Node();
        }

        void insert(int num, int index) {
            Node node = root;
            node.maxIndex = index;
            for (int i = 30; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (!node.containsKey(bit)) {
                    node.put(bit, new Node());
                }
                node = node.get(bit);
                node.maxIndex = index;
            }
        }

        int findMaxXor(int num, int l) {
            int res = 0;
            Node node = root;
            for (int i = 30; i >= 0; i--) {
                int bit = (num >> i) & 1;
                int toggledBit = bit ^ 1;
                if (node.containsKey(toggledBit)){
                    Node nextNode = node.get(toggledBit);
                    if (nextNode.maxIndex >= l) {
                        res |= (1 << i);
                        node = nextNode;
                    } else {
                        node = node.get(bit);
                    }
                } else {
                    node = node.get(bit);
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }

            int minLen = n + 1;
            Trie trie = new Trie();

            for (int r = 0; r < n; r++) {
                trie.insert(a[r], r);
                int left = 0;
                int right = r;
                int bestL = -1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    int currentMaxXor = trie.findMaxXor(a[r], mid);
                    if (currentMaxXor >= k) {
                        bestL = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                if (bestL != -1) {
                    minLen = Math.min(minLen, r - bestL + 1);
                    if (minLen == 2) {
                        break; // Early termination if the smallest possible is found
                    }
                }
            }

            if (minLen == n + 1) {
                System.out.println(-1);
            } else {
                System.out.println(minLen);
            }
        }

        in.close();
    }
}