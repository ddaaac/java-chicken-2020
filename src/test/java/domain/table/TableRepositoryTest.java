package domain.table;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TableRepositoryTest {
    @Test
    void createSize() {
        assertThat(TableRepository.tables()).hasSize(6);
    }
}