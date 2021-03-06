/************************************************************************
 * Licensed under Public Domain (CC0)                                    *
 *                                                                       *
 * To the extent possible under law, the person who associated CC0 with  *
 * this code has waived all copyright and related or neighboring         *
 * rights to this code.                                                  *
 *                                                                       *
 * You should have received a copy of the CC0 legalcode along with this  *
 * work. If not, see <http://creativecommons.org/publicdomain/zero/1.0/>.*
 ************************************************************************/

package com.lightbend.streams;

import com.lightbend.streams.spi.Stage;

import java.util.concurrent.CompletionStage;

/**
 * A builder for a closed reactive streams graph.
 *
 * When built, this builder returns a {@link CompletionStage} that will be redeemed with the result produced by the
 * subscriber of the stream when the stream completes normally, or will be redeemed with an error if the stream
 * encounters an error.
 *
 * @see ReactiveStreams
 * @param <T> The result of the stream.
 */
public final class CompletionBuilder<T> extends ReactiveStreamsBuilder<CompletionStage<T>> {

  CompletionBuilder(Stage stage, ReactiveStreamsBuilder<?> previous) {
    super(stage, previous);
  }

  @Override
  public CompletionStage<T> build(ReactiveStreamsEngine engine) {
    return engine.buildCompletion(verify(flatten(), false, false));
  }
}
