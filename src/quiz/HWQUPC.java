package quiz;



/**
 * Original code:
 * Copyright © 2000–2017, Robert Sedgewick and Kevin Wayne.
 *
 * Modifications:
 * Copyright (c) 2017. Phasmid Software
 */

/**
 * Height-weighted Quick Union with Path Compression
 */
public class HWQUPC {
    private int[] parent;   // parent[i] = parent of i
    private int[] height;   // height[i] = height of subtree rooted at i
    private int count;  // number of components
    private boolean pathCompression = false;

    /**
     * Initializes an empty union–find data structure with {@code n} sites
     * {@code 0} through {@code n-1}. Each site is initially in its own
     * component.
     *
     * @param  n the number of sites
     * @throws IllegalArgumentException if {@code n < 0}
     */
    public HWQUPC(int n) {
        count = n;
        parent = new int[n];
        height = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            height[i] = 1;
        }
    }

    /**
     * Returns the number of components.
     *
     * @return the number of components (between {@code 1} and {@code n})
     */
    public int count() {
        return count;
    }

    public void setPathCompression(boolean flag) {
        pathCompression = flag;
    }
    /**
     * Returns the component identifier for the component containing site {@code p}.
     *
     * @param  p the integer representing one site
     * @return the component identifier for the component containing site {@code p}
     * @throws IllegalArgumentException unless {@code 0 <= p < n}
     */
    public int find(int p) {
        validate(p);
        int root = p;
        while (root != parent[root])
            root = parent[root];
        if (!pathCompression)
            return root;
        // TODO implement path compression...
        parent[p] = root;
        return root;

        //End of TODO
    }

    // validate that p is a valid index
    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));
        }
    }

    /**
     * Returns true if the the two sites are in the same component.
     *
     * @param  p the integer representing one site
     * @param  q the integer representing the other site
     * @return {@code true} if the two sites {@code p} and {@code q} are in the same component;
     *         {@code false} otherwise
     * @throws IllegalArgumentException unless
     *         both {@code 0 <= p < n} and {@code 0 <= q < n}
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * Merges the component containing site {@code p} with the
     * the component containing site {@code q}.
     *
     * @param  p the integer representing one site
     * @param  q the integer representing the other site
     * @throws IllegalArgumentException unless
     *         both {@code 0 <= p < n} and {@code 0 <= q < n}
     */
    public void union(int p, int q) {
        // TODO make shorter root point to taller one
        int proot = find(p);
        int qroot = find(q);
        if (proot == qroot) return;
        if (height[proot] < height[qroot]) {
            parent[proot] = qroot;
        } else if (height[proot] > height[qroot]) {
            parent[qroot] = proot;
        } else {
            parent[qroot] = proot;
            height[proot] += 1;
        }
        /**  when we talk about size **/
//        if (height[proot] < height[qroot]) {
//            parent[proot] = qroot;
//            height[qroot] += height[proot];
//        } else {
//            parent[qroot] = proot;
//            height[proot] += height[qroot];
//        }
        //End of TODO
        count--;
    }
}