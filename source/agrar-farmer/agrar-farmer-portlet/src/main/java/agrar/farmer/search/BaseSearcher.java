package agrar.farmer.search;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public abstract class BaseSearcher<ObjectT> {
	
	protected final HttpServletRequest request;
	
	public BaseSearcher() {
		this.request = null;
	}
	
	public BaseSearcher(HttpServletRequest request) {
		this.request = request;
		getData();
	}


	public int getTotal() throws SystemException {
		return (int) countDynamicQuery(buildQuery());
	}	


	public List<ObjectT> getList(int start, int end) throws SystemException {
		final DynamicQuery query = buildQuery();
		query.setLimit(start, end);
		addQueryOrder(query);
		return buildDynamicQuery(query);
	}


	protected abstract void getData();


	protected DynamicQuery buildQuery() throws SystemException {
		return buildDynamicQuery();
	}


	protected DynamicQuery addQueryOrder(DynamicQuery query) {
		return query;
	}


	protected abstract DynamicQuery buildDynamicQuery();


	protected abstract List<ObjectT> buildDynamicQuery(DynamicQuery query) throws SystemException;
	

	protected abstract long countDynamicQuery(DynamicQuery query) throws SystemException;
		
}
