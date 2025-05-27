import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;


public class Build {

  /**
   * Prints words that are reachable from the given vertex and are strictly shorter than k characters.
   * If the vertex is null or no reachable words meet the criteria, prints nothing.
   *
   * @param vertex the starting vertex
   * @param k the maximum word length (exclusive)
   */
  public static void printShortWords(Vertex<String> vertex, int k) {
    Set<Vertex<String>> visited = new HashSet<>();
    Stack<Vertex<String>> stack = new Stack<>();
    stack.push(vertex);

    while(!stack.isEmpty()) 
    {
      Vertex<String> curr = stack.pop();

      if(visited.contains(curr) || curr == null) 
      {
        continue;
      }

      visited.add(curr);

      if(curr.data !=null && curr.data.length()< k) 
      {
        System.out.println(curr.data);
      }

      for(Vertex<String> n : curr.neighbors) 
      {
        if(!visited.contains(n)) 
        {
          stack.push(n);
        }
      }
    }
  }

  /**
   * Returns the longest word reachable from the given vertex, including its own value.
   *
   * @param vertex the starting vertex
   * @return the longest reachable word, or an empty string if the vertex is null
   */
  public static String longestWord(Vertex<String> vertex) {
    Set<Vertex<String>> visited = new HashSet<>();
    Stack<Vertex<String>> stack = new Stack<>();
    stack.push(vertex);

    String longest = "";

    while(!stack.isEmpty()) 
    {
      Vertex<String> curr = stack.pop();

      if(curr == null)
      {
        return "";
      }
      if(visited.contains(curr)) 
      {
        continue;
      }

      visited.add(curr);

      if(curr.data !=null && curr.data.length() > longest.length()) 
      {
        longest = curr.data;
      }

      for(Vertex<String> n : curr.neighbors) 
      {
        if(!visited.contains(n)) 
        {
          stack.push(n);
        }
      }
    }
    return longest;
  }

  /**
   * Prints the values of all vertices that are reachable from the given vertex and 
   * have themself as a neighbor.
   *
   * @param vertex the starting vertex
   * @param <T> the type of values stored in the vertices
   */
  public static <T> void printSelfLoopers(Vertex<T> vertex) {
    Set<Vertex<T>> visited = new HashSet<>();
    Stack<Vertex<T>> stack = new Stack<>();
    stack.push(vertex);

    while(!stack.isEmpty())
    {
      Vertex<T> curr = stack.pop();

      if(visited.contains(curr) || curr == null)
      {
        continue;
      }

      visited.add(curr);

      if(curr.neighbors.contains(curr))
      {
        System.out.println(curr.data);
      }

      for(Vertex<T> n : curr.neighbors) 
      {
        if(!visited.contains(n)) 
        {
          stack.push(n);
        }
      }
    }
  }

  /**
   * Determines whether it is possible to reach the destination airport through a series of flights
   * starting from the given airport. If the start and destination airports are the same, returns true.
   *
   * @param start the starting airport
   * @param destination the destination airport
   * @return true if the destination is reachable from the start, false otherwise
   */
  public static boolean canReach(Airport start, Airport destination) {
    
    return false;
  }

  /**
   * Returns the set of all values in the graph that cannot be reached from the given starting value.
   * The graph is represented as a map where each vertex is associated with a list of its neighboring values.
   *
   * @param graph the graph represented as a map of vertices to neighbors
   * @param starting the starting value
   * @param <T> the type of values stored in the graph
   * @return a set of values that cannot be reached from the starting value
   */
  public static <T> Set<T> unreachable(Map<T, List<T>> graph, T starting) {
    return new HashSet<>();
  }
}
