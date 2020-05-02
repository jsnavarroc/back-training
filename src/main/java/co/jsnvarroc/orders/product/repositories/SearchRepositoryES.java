/*
package co.jsnvarroc.orders.product.repositories;

import co.jsnvarroc.orders.common.domain.NonEmptyString;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class SearchRepositoryES implements  SearchRepository{

    private final Client client;
    @Autowired
    public SearchRepositoryES(Client client){
        this.client=client;
    }


    @Override
    public List<Object> searchByText(NonEmptyString value) {
        TermQueryBuilder queryBuilder = QueryBuilders.termQuery("name", value.getValue());
        SearchResponse product = client.prepareSearch("products")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(queryBuilder)
                .get();
        product.getHits().spliterator();
        return Collections.emptyList();
    }
}
*/
