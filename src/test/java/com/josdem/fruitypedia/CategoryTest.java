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

package com.josdem.fruitypedia;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.josdem.fruitypedia.model.Category;
import com.josdem.fruitypedia.repository.CategoryRepository;
import com.josdem.fruitypedia.service.CategoryService;
import com.josdem.fruitypedia.service.impl.CategoryServiceImpl;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CategoryTest {

  @Mock private CategoryRepository categoryRepository;

  private CategoryService service;

  private Integer categoryId = 1;
  private String language = "es";
  private Category category = new Category(categoryId, language, "Curativos");

  @BeforeEach
  void setup() {
    MockitoAnnotations.openMocks(this);
    service = new CategoryServiceImpl(categoryRepository);
  }

  @Test
  @DisplayName("Should find all categories")
  void shouldFindAllCategories() {
    when(categoryRepository.findByI18nOrderById(language)).thenReturn(List.of(category));
    service.findByI18n(language);
    verify(categoryRepository).findByI18nOrderById(language);
  }
}
