/*
  Copyright 2021 Jose Morales <joseluis.delacruz@gmail.com>
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
  http://www.apache.org/licenses/LICENSE-2.0
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/

package com.jos.dem.jugoterapia.webflux.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jos.dem.jugoterapia.webflux.model.Category;

import java.util.List;

public interface CategoryRepository extends MongoRepository<Category, Integer> {
  List<Category> findByI18nOrderById(String language);
}
