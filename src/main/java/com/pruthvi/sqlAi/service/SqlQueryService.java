package com.pruthvi.sqlAi.service;

import com.pruthvi.sqlAi.model.QueryResult;

public interface SqlQueryService {
     QueryResult processQuestion(String question);
}
