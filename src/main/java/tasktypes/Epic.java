package tasktypes;

public class Epic extends Task {
    protected String[] subtasks = new String[0];

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    public String[] getSubtasks() {
        return subtasks;
    }

    @Override
    protected boolean matches(String query) {
        for (String subtask : subtasks) {
            if (subtask.toLowerCase().contains(query)) {
                return true;
            }
        }
        return false;
    }
}
