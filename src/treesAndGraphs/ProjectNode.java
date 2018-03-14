package treesAndGraphs;

import java.util.ArrayList;

public class ProjectNode {
    public String data;
    public ArrayList<ProjectNode> dependencies;

    public ProjectNode(String data) {
        this.data = data;
        dependencies = new ArrayList<ProjectNode>();
    }
}