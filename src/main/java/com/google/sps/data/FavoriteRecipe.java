// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.data;

/**
 * Class representing a user's favorite recipe
 */
public class FavoriteRecipe {
  private long favoriteId;
  private String userId;
  private long recipeId;
  private String dateFavorited;

  /**
    * @param favoriteId The unique id of the favorite object
    * @param userId The unique id of the profile.
    * @param recipeId The ids of the recipe that the user favorited
    */
  public FavoriteRecipe(long favoriteId, String userId, long recipeId, String dateFavorited) {
    this.favoriteId = favoriteId;
    this.userId = userId;
    this.recipeId = recipeId;
    this.dateFavorited = dateFavorited;
  }
}