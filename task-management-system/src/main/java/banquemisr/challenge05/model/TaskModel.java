package banquemisr.challenge05.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskModel {
    private Integer id;
    private String title;
    private String description;
    private TaskStatus status;
    private String priority;
    private String dueDate;
}
