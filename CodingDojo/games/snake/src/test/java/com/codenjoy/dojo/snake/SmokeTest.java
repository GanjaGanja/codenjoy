package com.codenjoy.dojo.snake;

import com.codenjoy.dojo.client.LocalGameRunner;
import com.codenjoy.dojo.services.settings.SettingsImpl;
import com.codenjoy.dojo.snake.client.Board;
import com.codenjoy.dojo.snake.client.ai.ApofigSolver;
import com.codenjoy.dojo.snake.services.GameRunner;
import com.codenjoy.dojo.services.Dice;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SmokeTest {

    @Test
    public void test() {
        // given
        List<String> messages = new LinkedList<>();

        LocalGameRunner.timeout = 0;
        LocalGameRunner.out = (e) -> messages.add(e);
        LocalGameRunner.countIterations = 10;

        Dice dice = LocalGameRunner.getDice(
                0, 2, 4, 1, 2, // random numbers
                0, 3, 5, 6, 6,
                0, 4, 6, 1, 3,
                0, 4, 7, 6, 6,
                0, 4, 5, 6, 3,
                2, 1, 4, 0, 2,
                3, 5, 4, 6, 1,
                2, 1, 5, 3, 2,
                0, 1, 3, 2, 1);

        GameRunner gameType = new GameRunner() {
            @Override
            protected Dice getDice() {
                return dice;
            }

            @Override
            protected SettingsImpl createSettings() {
                SettingsImpl settings = super.createSettings();
                settings.addEditBox("Board size").type(Integer.class).update(7);
                return settings;
            }
        };

        // when
        LocalGameRunner.run(gameType,
                new ApofigSolver(dice),
                new Board());

        // then
        assertEquals("DICE:0\n" +
                        "DICE:2\n" +
                        "DICE:4\n" +
                        "DICE:1\n" +
                        "DICE:2\n" +
                        "DICE:0\n" +
                        "DICE:3\n" +
                        "DICE:5\n" +
                        "1:Board:\n" +
                        "1:☼☼☼☼☼☼☼\n" +
                        "1:☼  ☺  ☼\n" +
                        "1:☼☻    ☼\n" +
                        "1:☼ ╘►  ☼\n" +
                        "1:☼     ☼\n" +
                        "1:☼     ☼\n" +
                        "1:☼☼☼☼☼☼☼\n" +
                        "1:\n" +
                        "1:Apple at: [[3,5]]\n" +
                        "1:Stones at: [[1,4]]\n" +
                        "1:Head at: [3,3]\n" +
                        "1:Snake at: [[3,3], [2,3]]\n" +
                        "1:Current direction: RIGHT\n" +
                        "1:Answer: UP\n" +
                        "------------------------------------------\n" +
                        "1:Board:\n" +
                        "1:☼☼☼☼☼☼☼\n" +
                        "1:☼  ☺  ☼\n" +
                        "1:☼☻ ▲  ☼\n" +
                        "1:☼  ╙  ☼\n" +
                        "1:☼     ☼\n" +
                        "1:☼     ☼\n" +
                        "1:☼☼☼☼☼☼☼\n" +
                        "1:\n" +
                        "1:Apple at: [[3,5]]\n" +
                        "1:Stones at: [[1,4]]\n" +
                        "1:Head at: [3,4]\n" +
                        "1:Snake at: [[3,4], [3,3]]\n" +
                        "1:Current direction: UP\n" +
                        "1:Answer: UP\n" +
                        "Fire Event: EAT_APPLE\n" +
                        "DICE:6\n" +
                        "DICE:6\n" +
                        "DICE:0\n" +
                        "DICE:4\n" +
                        "DICE:6\n" +
                        "DICE:1\n" +
                        "DICE:3\n" +
                        "DICE:0\n" +
                        "DICE:4\n" +
                        "DICE:7\n" +
                        "DICE_CORRECTED < 7 :0\n" +
                        "DICE:6\n" +
                        "DICE:6\n" +
                        "DICE:0\n" +
                        "DICE:4\n" +
                        "DICE:5\n" +
                        "DICE:6\n" +
                        "DICE:3\n" +
                        "DICE:2\n" +
                        "------------------------------------------\n" +
                        "1:Board:\n" +
                        "1:☼☼☼☼☼☼☼\n" +
                        "1:☼  ▲  ☼\n" +
                        "1:☼☻ ║  ☼\n" +
                        "1:☼  ╙  ☼\n" +
                        "1:☼  ☺  ☼\n" +
                        "1:☼     ☼\n" +
                        "1:☼☼☼☼☼☼☼\n" +
                        "1:\n" +
                        "1:Apple at: [[3,2]]\n" +
                        "1:Stones at: [[1,4]]\n" +
                        "1:Head at: [3,5]\n" +
                        "1:Snake at: [[3,5], [3,3], [3,4]]\n" +
                        "1:Current direction: UP\n" +
                        "1:Answer: LEFT\n" +
                        "------------------------------------------\n" +
                        "1:Board:\n" +
                        "1:☼☼☼☼☼☼☼\n" +
                        "1:☼ ◄╗  ☼\n" +
                        "1:☼☻ ╙  ☼\n" +
                        "1:☼     ☼\n" +
                        "1:☼  ☺  ☼\n" +
                        "1:☼     ☼\n" +
                        "1:☼☼☼☼☼☼☼\n" +
                        "1:\n" +
                        "1:Apple at: [[3,2]]\n" +
                        "1:Stones at: [[1,4]]\n" +
                        "1:Head at: [2,5]\n" +
                        "1:Snake at: [[2,5], [3,4], [3,5]]\n" +
                        "1:Current direction: LEFT\n" +
                        "1:Answer: DOWN\n" +
                        "------------------------------------------\n" +
                        "1:Board:\n" +
                        "1:☼☼☼☼☼☼☼\n" +
                        "1:☼ ╔╕  ☼\n" +
                        "1:☼☻▼   ☼\n" +
                        "1:☼     ☼\n" +
                        "1:☼  ☺  ☼\n" +
                        "1:☼     ☼\n" +
                        "1:☼☼☼☼☼☼☼\n" +
                        "1:\n" +
                        "1:Apple at: [[3,2]]\n" +
                        "1:Stones at: [[1,4]]\n" +
                        "1:Head at: [2,4]\n" +
                        "1:Snake at: [[2,4], [2,5], [3,5]]\n" +
                        "1:Current direction: DOWN\n" +
                        "1:Answer: DOWN\n" +
                        "------------------------------------------\n" +
                        "1:Board:\n" +
                        "1:☼☼☼☼☼☼☼\n" +
                        "1:☼ ╓   ☼\n" +
                        "1:☼☻║   ☼\n" +
                        "1:☼ ▼   ☼\n" +
                        "1:☼  ☺  ☼\n" +
                        "1:☼     ☼\n" +
                        "1:☼☼☼☼☼☼☼\n" +
                        "1:\n" +
                        "1:Apple at: [[3,2]]\n" +
                        "1:Stones at: [[1,4]]\n" +
                        "1:Head at: [2,3]\n" +
                        "1:Snake at: [[2,3], [2,4], [2,5]]\n" +
                        "1:Current direction: DOWN\n" +
                        "1:Answer: DOWN\n" +
                        "------------------------------------------\n" +
                        "1:Board:\n" +
                        "1:☼☼☼☼☼☼☼\n" +
                        "1:☼     ☼\n" +
                        "1:☼☻╓   ☼\n" +
                        "1:☼ ║   ☼\n" +
                        "1:☼ ▼☺  ☼\n" +
                        "1:☼     ☼\n" +
                        "1:☼☼☼☼☼☼☼\n" +
                        "1:\n" +
                        "1:Apple at: [[3,2]]\n" +
                        "1:Stones at: [[1,4]]\n" +
                        "1:Head at: [2,2]\n" +
                        "1:Snake at: [[2,2], [2,3], [2,4]]\n" +
                        "1:Current direction: DOWN\n" +
                        "1:Answer: RIGHT\n" +
                        "Fire Event: EAT_APPLE\n" +
                        "DICE:1\n" +
                        "DICE:4\n" +
                        "DICE:0\n" +
                        "DICE:2\n" +
                        "DICE:3\n" +
                        "DICE:5\n" +
                        "------------------------------------------\n" +
                        "1:Board:\n" +
                        "1:☼☼☼☼☼☼☼\n" +
                        "1:☼  ☺  ☼\n" +
                        "1:☼☻╓   ☼\n" +
                        "1:☼ ║   ☼\n" +
                        "1:☼ ╚►  ☼\n" +
                        "1:☼     ☼\n" +
                        "1:☼☼☼☼☼☼☼\n" +
                        "1:\n" +
                        "1:Apple at: [[3,5]]\n" +
                        "1:Stones at: [[1,4]]\n" +
                        "1:Head at: [3,2]\n" +
                        "1:Snake at: [[3,2], [2,2], [2,3], [2,4]]\n" +
                        "1:Current direction: RIGHT\n" +
                        "1:Answer: UP\n" +
                        "------------------------------------------\n" +
                        "1:Board:\n" +
                        "1:☼☼☼☼☼☼☼\n" +
                        "1:☼  ☺  ☼\n" +
                        "1:☼☻    ☼\n" +
                        "1:☼ ╓▲  ☼\n" +
                        "1:☼ ╚╝  ☼\n" +
                        "1:☼     ☼\n" +
                        "1:☼☼☼☼☼☼☼\n" +
                        "1:\n" +
                        "1:Apple at: [[3,5]]\n" +
                        "1:Stones at: [[1,4]]\n" +
                        "1:Head at: [3,3]\n" +
                        "1:Snake at: [[3,3], [2,2], [2,3], [3,2]]\n" +
                        "1:Current direction: UP\n" +
                        "1:Answer: UP\n" +
                        "------------------------------------------\n" +
                        "1:Board:\n" +
                        "1:☼☼☼☼☼☼☼\n" +
                        "1:☼  ☺  ☼\n" +
                        "1:☼☻ ▲  ☼\n" +
                        "1:☼  ║  ☼\n" +
                        "1:☼ ╘╝  ☼\n" +
                        "1:☼     ☼\n" +
                        "1:☼☼☼☼☼☼☼\n" +
                        "1:\n" +
                        "1:Apple at: [[3,5]]\n" +
                        "1:Stones at: [[1,4]]\n" +
                        "1:Head at: [3,4]\n" +
                        "1:Snake at: [[3,4], [2,2], [3,2], [3,3]]\n" +
                        "1:Current direction: UP\n" +
                        "1:Answer: UP\n" +
                        "Fire Event: EAT_APPLE\n" +
                        "DICE:4\n" +
                        "DICE:6\n" +
                        "DICE:1\n" +
                        "DICE:2\n" +
                        "------------------------------------------",
                String.join("\n", messages));

    }
}