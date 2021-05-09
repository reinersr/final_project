# Large Scale Data Processing: Final Project
# Evi Prousanidou, Robert Reiners

## Graph matching
For the final project, you are provided 6 CSV files, each containing an undirected graph, which can be found [here](https://drive.google.com/file/d/1khb-PXodUl82htpyWLMGGNrx-IzC55w8/view?usp=sharing). The files are as follows:  

|           File name           |        Number of edges       |  # of Matching  |  Run time | Machine   
| ------------------------------| ---------------------------- | --------------- | --------- | --------- |                
| com-orkut.ungraph.csv         | 117185083                    | 44988           | 6 h (34)  | CPU       |
| twitter_original_edges.csv    | 63555749                     | 15855           | h h       | CPU       |
| soc-LiveJournal1.csv          | 42851237                     | 44010           | 6 h (39)  | CPU       |
| soc-pokec-relationships.csv   | 22301964                     | 42714           | 6 h (40)  | CPU       |
| musae_ENGB_edges.csv          | 35324                        | 1540            |  46       | CPU       |
| log_normal_100.csv            | 2671                         | 49              |   6       | CPU       |


Your goal is to compute a matching as large as possible for each graph.


## Luby Algorithm

Luby algorithm is used to get the Maximal Independent Set (MIS). By changing the vertices to edges we get the maximal matching of the graph.

Consider the algorithm of this form for G = (V, E):
   1. I = ∅, G' = G <br>
   2. While G' is not the empty graph <br>
      (a) For the set of active vertices S ⊆ V select each vertex v independently to have a value of 1 with probability Pr(v) and 0 otherwise. Suppose Pr(v) = 1/2d<sub>v</sub> , where dv ≡ degree of v. <br>
      (b) For every vertex in S send value b<sub>v</sub> to neighbors
      (c) Add edge between vertex v where b<sub>v</sub> = 1 and vertex x where b<sub>v</sub> = 0 to matching M<br>
      (d) Send message to neighbors of edge v and u that the edge has been added to the matching M <br>
      (e) Remove v and x and the neighbors of both from G'. <br>

The algorithm terminates in O(log n) rounds with high probability.


## Augmenting Path
A maximum matching M is said to be Maximum if for any other matching M', |M|≥ |M'|

  <u> If matching M is maximum -> M is maximal </u>

So, once we have the maximal matching we can get the maximum matching through the augmenting paths

 -An augmenting path is a path whose endpoints are free and the edges on path alternate between unmatched and matched
 -We can increase the size of a matching by flipping an augmenting path
 -If there are no augmenting paths => the current matching is optimal meaning the maximum matching
 - If the shortest augmenting paths have length ≥2𝑘−1 => the current matching is at least (1−1/𝑘)⋅𝑂𝑃𝑇

  * Discussion about the advantages of your algorithm(s). For example, does it guarantee a constraint on the number of shuffling rounds (say `O(log log n)` rounds)? Does it give you an approximation guarantee on the quality of the matching? If your algorithm has such a guarantee, please provide proofs or scholarly references as to why they hold in your report.


## Randomization

We ran 100 iterations of a randomization algorithm where the edges were randomized and were added to the output if neither of the nodes were already a member of the output set.The largest set was then taken. This took a long time to run and did not finish for the 4 largest graphs. In order to get a set we took the first 100,000 edges out of the set after it was randomized and ran the randomization algorithm on that subset. These returned a set and wither finished all 100 iterations of the algorithm or finished a smaller number. The number finished, if under 100, is reflected in parentheses in the table above. The algorithm runs in O(n^3).

This algorithm is easily implemented and provides a good matching. The matching is not perfect and could be missing some nodes, but will run relatively quickly and without a large amount of computational power.
