package treesAndGraphs;

import java.util.ArrayList;

public class ProjectNode {
    public String data;
    public boolean built;
    public ArrayList<ProjectNode> dependencies;

    public ProjectNode(String data) {
        this.data = data;
        this.built = false;
        dependencies = new ArrayList<ProjectNode>();
    }
}