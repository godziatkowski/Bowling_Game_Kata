/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bowling_game_kata;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 *
 * @author Godzio
 */
public class BowlingGameTest {

    private final Game game = new Game();
    private int expectedScore;

    @Test
    public void twentyShots_zeroHits() throws Exception {
        expectedScore = 0;
        hitNPinsInEachOfNRolls( 20, 0 );
        assertThat( game.score(), is( expectedScore ) );
    }

    @Test
    public void oneShot_oneKill() throws Exception {
        expectedScore = 20;
        hitNPinsInEachOfNRolls( 20, 1 );
        assertThat( game.score(), is( expectedScore ) );
    }

    @Test
    public void oneSpare_andZeroForRest_expectedScoreIs14() {
        expectedScore = 14;
        spareRoll();
        game.roll( 2 );
        hitNPinsInEachOfNRolls( 17, 0 );
        assertThat( game.score(), is( expectedScore ) );
    }

    @Test
    public void oneStrike_andZeroForRest_expectedScoreIs26() {
        expectedScore = 26;
        strikeRoll();
        game.roll( 3 );
        game.roll( 5 );
        hitNPinsInEachOfNRolls( 17, 0 );
        assertThat( game.score(), is( expectedScore ) );
    }

    @Test
    public void tenStrikes_expectedScoreIs300() {
        expectedScore = 300;
        hitNPinsInEachOfNRolls( 12, 10 );
        assertThat( game.score(), is( expectedScore ) );
    }

    private void strikeRoll() {
        game.roll( 10 );
    }

    private void spareRoll() {
        game.roll( 5 );
        game.roll( 5 );
    }

    private void hitNPinsInEachOfNRolls( int rolls, int hitsPerRoll ) {
        for ( int i = 0; i < rolls; i++ ) {
            game.roll( hitsPerRoll );
        }
    }
}
