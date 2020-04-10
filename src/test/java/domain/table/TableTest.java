package domain.table;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TableTest {
    @Test
    void create() {
        assertThat(new Table(1)).isInstanceOf(Table.class);
    }
}