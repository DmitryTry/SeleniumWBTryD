package selenium.task40.tableSortSearch;

import static java.lang.String.format;

public class WorkerTable {

    private final String name;
    private final String position;
    private final String office;

    public WorkerTable(String name, String position, String office) {
        this.name = name;
        this.position = position;
        this.office = office;
    }

    @Override
    public String toString() {
        return format(
                "Name: '%s', Position: '%s', Office: '%s'",
                name,
                position,
                office
        );
    }
}
