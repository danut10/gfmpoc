package ro.cegeka.gfmpoc.common.core.impl;

import java.util.ArrayList;
import java.util.List;

public class Pager {
	private Integer pageSize;
	private Integer chapterSize;
	private Integer recordCount;
	private Integer pageNo;

	private Integer recordNoMin;
	private Integer recordNoMax;
	private Integer pageCount;
	private List<Integer> visiblePages;

	public Pager() {
		visiblePages = new ArrayList<Integer>();
		pageSize = 10;
		chapterSize = 5;
		pageNo = 1;
	}

	public Pager build() {
		/*
		 * date de intrare sunt: pageSize, chapterSize, recordCount, pageNo,
		 * daca datele de intrare sunt nule trebuie sa iasa (sau sa dea eroare)
		 *
		 * datele de iesire sunt: pageCount, recordNoMin, recordNoMax
		 */

		/*
		 * tratarea cazului special cand recordCount e nul sau 0
		 */
		if ((recordCount == null) || (recordCount == 0)) {
			pageCount = 0;
			pageNo = 0;
			recordNoMin = 0;
			recordNoMax = 0;
			return this;
		}

		/*
		 * calculul efectiv pageCount - va fi minim 1
		 */
		pageCount = ((recordCount - 1) / pageSize) + 1;


		/*
		 * ajustari pageNo
		 */
		if (pageNo == null) pageNo = 1;
		if (pageNo <= 0) pageNo = 1;
		if (pageNo >= pageCount) pageNo = pageCount;

		/*
		 * calcul chapter
		 */
		if ((chapterSize == null) || (chapterSize == 0)) {
			chapterSize = 5;
		}
		Integer chapterStart;
		Integer chapterEnd;
		if (pageNo <= chapterSize / 2) {
			chapterStart = 1;
			chapterEnd = chapterSize;
		} else if (pageNo > pageCount - chapterSize / 2) {
			chapterStart = Math.max(1, pageCount - chapterSize + 1);
			chapterEnd = pageCount;
		} else {
			chapterStart = pageNo - chapterSize / 2;
			chapterEnd = chapterStart + chapterSize - 1;
		}
		if (chapterEnd > pageCount) {
			chapterEnd = pageCount;
		}
		visiblePages.clear();
		for (int i = chapterStart; i <= chapterEnd; i++) {
			visiblePages.add(i);
		}

		/*
		 * calcul efectiv recordNo
		 */
		recordNoMin = (pageNo - 1) * pageSize;
		recordNoMax = pageNo * pageSize - 1;

		return this;
	}

	public Integer getRecordCount() { return recordCount; }
	public Pager setRecordCount(Integer recordCount) { this.recordCount = recordCount; return this; }

	public Integer getPageSize() { return pageSize; }
	public Pager setPageSize(Integer pageSize) { this.pageSize = pageSize; return this; }

	public Integer getChapterSize() { return chapterSize; }
	public Pager setChapterSize(Integer chapterSize) { this.chapterSize = chapterSize; return this; }

	public Integer getPageNo() { return pageNo; }
	public Pager setPageNo(Integer pageNo) {
		this.pageNo = pageNo; return this;
	}

	public Integer getPageCount() { return pageCount; }
	public List<Integer> getVisiblePages() { return visiblePages; }
	public Integer getRecordNoMin() { return recordNoMin; }
	public Integer getRecordNoMax() { return recordNoMax; }



}

